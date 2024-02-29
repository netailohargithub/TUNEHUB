package com.kodnest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.demo.entity.Playlist;

public interface PlaylistRepository 
	extends JpaRepository<Playlist, Integer>{

}
