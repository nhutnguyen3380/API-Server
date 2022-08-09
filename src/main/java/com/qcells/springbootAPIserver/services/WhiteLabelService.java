/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.qcells.springbootAPIserver.services;

import com.qcells.springbootAPIserver.Entity.WhiteLabelList;
import com.qcells.springbootAPIserver.repository.WhiteLabelRepository;
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
