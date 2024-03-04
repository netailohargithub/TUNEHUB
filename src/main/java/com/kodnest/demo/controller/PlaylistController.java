package com.kodnest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.demo.entity.Playlist;
import com.kodnest.demo.entity.Song;
import com.kodnest.demo.service.PlaylistService;
import com.kodnest.demo.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating the playlist table
		playlistService.addplaylist(playlist);
	
		//updating the song table
		List<Song> songList = playlist.getSongs();
		for (Song s : songList) {
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
			
		}
		return "adminhome";
	}
	
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> allplaylist = playlistService.fetchAllPlaylists();
		
		model.addAttribute("allplaylist", allplaylist);
		return "displayplaylist";
	}

}
