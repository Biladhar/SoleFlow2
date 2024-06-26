package com.bilel.soleflow2.services;

import java.util.List;

import com.bilel.soleflow2.models.Color;

public interface ColorService {

    Color saveColor(Color c);
    Color updateColor(Color c);
    void deleteColor(Color c);
    void deleteColorById(Long id);
    Color getColor(Long id);
    List<Color> getAllColors();

}
