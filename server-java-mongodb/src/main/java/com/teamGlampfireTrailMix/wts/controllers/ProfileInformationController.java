package com.teamGlampfireTrailMix.wts.controllers;

import com.teamGlampfireTrailMix.wts.models.ProfileInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamGlampfireTrailMix.wts.models.ProfileInformationRepository;

@RestController
@RequestMapping("/profileinfo")
public class ProfileInformationController {

    private final ProfileInformationRepository profileInformationRepository;

    @Autowired
    public ProfileInformationController(ProfileInformationRepository profileInformationRepository) {
        this.profileInformationRepository = profileInformationRepository;
    }

    @GetMapping()
    public ProfileInformation readProfileInformation() {
        return profileInformationRepository.findById("0").orElse(null);
    }

    @PostMapping()
    public ProfileInformation createProfileInformation(@RequestBody ProfileInformation profileInformation) {
        profileInformation.setId("0");
        return profileInformationRepository.save(profileInformation);
    }

    @PutMapping()
    public ProfileInformation updateProfileInformation(@RequestBody ProfileInformation profileInformation) {
        ProfileInformation foundProfileInformation = profileInformationRepository.findById("0").orElse(null);

        if (foundProfileInformation == null) {
            foundProfileInformation = new ProfileInformation();
            foundProfileInformation.setId("0");
        }

        foundProfileInformation.setFirstName(profileInformation.getFirstName());
        foundProfileInformation.setLastName(profileInformation.getLastName());
        foundProfileInformation.setPic(profileInformation.getPic());
        foundProfileInformation.setAge(profileInformation.getAge());
        foundProfileInformation.setLanguages(profileInformation.getLanguages());
        foundProfileInformation.setBio(profileInformation.getBio());
        foundProfileInformation.setEmail(profileInformation.getEmail());
        foundProfileInformation.setFacebook(profileInformation.getFacebook());
        foundProfileInformation.setTwitter(profileInformation.getTwitter());
        foundProfileInformation.setInstagram(profileInformation.getInstagram());
        foundProfileInformation.setYoutube(profileInformation.getYoutube());
        foundProfileInformation.setLinkedin(profileInformation.getLinkedin());
        foundProfileInformation.setGithub(profileInformation.getGithub());
        foundProfileInformation.setReddit(profileInformation.getReddit());
        profileInformationRepository.save(foundProfileInformation);
        return foundProfileInformation;
    }

    @DeleteMapping("/{id}")
    public void deleteProfileInformation(@PathVariable String id) {
        profileInformationRepository.deleteById(id);
    }

}