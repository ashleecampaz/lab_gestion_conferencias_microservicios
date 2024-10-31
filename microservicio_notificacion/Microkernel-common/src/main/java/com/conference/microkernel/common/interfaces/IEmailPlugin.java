/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.microkernel.common.interfaces;

import com.conference.microkernel.common.entities.Email;

/**
 *
 * @author Ashlee Campaz
 */
public interface IEmailPlugin {
    public void EnviarEmail(Email e);
}
