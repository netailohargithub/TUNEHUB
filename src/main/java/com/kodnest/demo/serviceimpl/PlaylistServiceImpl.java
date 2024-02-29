package com.kodnest.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.demo.entity.Playlist;
import com.kodnest.demo.repository.PlaylistRepository;
import com.kodnest.demo.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> allplaylist = playlistRepository.findAll();
		return allplaylist;
	}

}
		
		
	


