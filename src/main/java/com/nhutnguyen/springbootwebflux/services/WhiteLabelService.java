/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.services;

import com.nhutnguyen.springbootwebflux.Entity.WhiteLabelList;
import com.nhutnguyen.springbootwebflux.repository.WhiteLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhiteLabelService
{
    @Autowired
    private WhiteLabelRepository whiteLabelRepository;

    public List<WhiteLabelList> getAllWhiteLabelList()
    {
        return whiteLabelRepository.findAllWhiteLabelList();
    }

}
