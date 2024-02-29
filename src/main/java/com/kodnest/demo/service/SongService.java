package com.kodnest.demo.service;

import java.util.List;

import com.kodnest.demo.entity.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExists(String name);

	public void updateSong(Song s);

}