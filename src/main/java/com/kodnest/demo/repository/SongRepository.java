package com.kodnest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.demo.entity.Song;

public interface SongRepository 
extends JpaRepository<Song, Integer>{

	public Song findByName(String name);

}