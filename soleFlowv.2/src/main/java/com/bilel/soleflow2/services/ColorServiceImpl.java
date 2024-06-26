package com.bilel.soleflow2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilel.soleflow2.models.Color;
import com.bilel.soleflow2.repositories.ColorRepository;

@Service
public class ColorServiceImpl implements ColorService{

    @Autowired
    private ColorRepository colorRepository;

	@Override
	public Color saveColor(Color c) {
		return colorRepository.save(c);
	}

	@Override
	public Color updateColor(Color c) {
		return colorRepository.save(c);
	}

	@Override
	public void deleteColor(Color c) {
        colorRepository.delete(c);
		
	}

	@Override
	public void deleteColorById(Long id) {
        colorRepository.deleteById(id);
		
	}

	@Override
	public Color getColor(Long id) {
		return colorRepository.findById(id).get();
	}

	@Override
	public List<Color> getAllColors() {
		return colorRepository.findAll();
	}

    

}
