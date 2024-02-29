package com.kodnest.demo.service;

import java.util.List;

import com.kodnest.demo.entity.Playlist;

public interface PlaylistService {

	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();


}