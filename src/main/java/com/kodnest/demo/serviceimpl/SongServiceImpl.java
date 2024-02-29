package com.kodnest.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.demo.entity.Song;
import com.kodnest.demo.repository.SongRepository;
import com.kodnest.demo.service.SongService;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songRepository;

	@Override
	public void addSong(Song song) {
		songRepository.save(song);

	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songRepository.findAll();
		return songs;
	}

	@Override
	public boolean songExists(String name) {
		Song song = songRepository.findByName(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
	}

}