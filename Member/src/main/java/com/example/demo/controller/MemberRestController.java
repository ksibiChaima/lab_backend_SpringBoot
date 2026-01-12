package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberRestController {

  private final IMemberService memberService;

  @RequestMapping(value = "/membres", method = RequestMethod.GET)
  public List<Membre> findMembres() {
    return memberService.findAll();
  }

  @GetMapping(value = "/membres/{id}")
  public Membre findOneMemberById(@PathVariable("id") Long id) {
    return memberService.findMember(id);
  }

  @GetMapping(value = "/membres/search/cin")
  public Membre findOneMemberByCin(@RequestParam("cin") String cin) {
    return memberService.findByCin(cin);
  }

  @GetMapping(value = "/membres/search/email")
  public Membre findOneMemberByEmail(@RequestParam("email") String email) {
    return memberService.findByEmail(email);
  }

  @PostMapping(value = "/membres/enseignant")
  public Membre addEnseignant(@RequestBody EnseignantChercheur m) {
    return memberService.addMember(m);
  }

  @PostMapping(value = "/membres/etudiant")
  public Membre addEtudiant(@RequestBody Etudiant e) {
    return memberService.addMember(e);
  }

  @DeleteMapping(value = "/membres/{id}")
  public void deleteMembre(@PathVariable("id") Long id) {
    memberService.deleteMember(id);
  }

  @PutMapping(value = "/membres/etudiant/{id}")
  public Membre updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant p) {
    p.setId(id);
    return memberService.updateMember(p);
  }

  @PutMapping(value = "/membres/enseignant/{id}")
  public Membre updateEnseignant(@PathVariable("id") Long id, @RequestBody EnseignantChercheur p) {
    p.setId(id);
    return memberService.updateMember(p);
  }

  //  enrich full member with pubs + outils + events
  @GetMapping("/fullmember/{id}")
  public Membre findAFullMember(@PathVariable(name = "id") Long id) {
    Membre mbr = memberService.findMember(id);
    mbr.setPubs(memberService.findPublicationparauteur(id));
    mbr.setOutils(memberService.findAllOutilparauteur(id));
    mbr.setEvents(memberService.findAllEventparauteur(id));
    return mbr;
  }
  @GetMapping("/membres/full")
  public List<Membre> findAllFullMembers() {
      List<Membre> membres = memberService.findAll();
      
      for (Membre membre : membres) {
          membre.setPubs(memberService.findPublicationparauteur(membre.getId()));
          membre.setOutils(memberService.findAllOutilparauteur(membre.getId()));
          membre.setEvents(memberService.findAllEventparauteur(membre.getId()));
      }
      
      return membres;
  }
  @PutMapping(value = "/membres/{id}")
  public Membre updateMembre(@PathVariable("id") Long id, @RequestBody Membre m) {
      m.setId(id);
      return memberService.updateMember(m);
  }

  // -----------------------------
  // Endpoints relations (API clean)
  // -----------------------------

  @GetMapping("/membres/{id}/publications")
  public List<PublicationBean> getMemberPublications(@PathVariable("id") Long id) {
    return memberService.findPublicationparauteur(id);
  }

  @GetMapping("/membres/{id}/outils")
  public List<OutilBean> getMemberOutils(@PathVariable("id") Long id) {
    return memberService.findAllOutilparauteur(id);
  }

  @GetMapping("/membres/{id}/events")
  public List<EventBean> getMemberEvents(@PathVariable("id") Long id) {
    return memberService.findAllEventparauteur(id);
  }

  @PostMapping("/membres/{id}/outils")
  public List<OutilBean> createOutilForMember(@PathVariable("id") Long id, @RequestBody OutilBean outil) {
    return memberService.createOutil(id, outil);
  }

  @DeleteMapping("/membres/{id}/outils/{outilId}")
  public String deleteOutilForMember(@PathVariable("id") Long id, @PathVariable("outilId") Long outilId) {
    return memberService.deleteOutil(id, outilId);
  }

  @PostMapping("/membres/{id}/events")
  public List<EventBean> createEventForMember(@PathVariable("id") Long id, @RequestBody EventBean event) {
    return memberService.createEvent(id, event);
  }

  @DeleteMapping("/membres/{id}/events/{eventId}")
  public String deleteEventForMember(@PathVariable("id") Long id, @PathVariable("eventId") Long eventId) {
    return memberService.deleteEvent(id, eventId);
  }

  @PostMapping("/membres/{id}/publications/{pubId}")
  public void affectPublication(@PathVariable("id") Long id, @PathVariable("pubId") Long pubId) {
    memberService.affecterauteurTopublication(id, pubId);
  }
}