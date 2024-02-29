package com.kodnest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.demo.entity.Song;
import com.kodnest.demo.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song){

		boolean songStatus = songService.songExists(song.getName());
		if(songStatus==false) {
			songService.addSong(song);	
			System.out.println("Song added Successfully");
		}
		else {
			System.out.println("Song already exists");
		}
		return "adminhome";
	}

	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "displaysongs";
	}

	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium = false;
		if(premium) {
			List<Song> songList = songService.fetchAllSongs();
			model.addAttribute("songs", songList);
			return "displaysongs";
		}else {
			return "subscriptionform";
		}
	}



}