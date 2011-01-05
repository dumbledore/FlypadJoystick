/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.flypad.joystick;

import com.sun.jna.Structure;

/**
 *
 * @author albus
 */
public class JoystickState extends Structure {
    /* Signature to identify packet to PPJoy IOCTL */
    public int signature = 0x53544143;
    /* Num of analog values we pass */
    public byte numAnalog = 8;
    /* Analog values */
    public int[] analog;
    /* Num of digital values we pass */
    public byte numDigital = 16;
    /* Digital values */
    public byte[] digital;

    public JoystickState() {
        analog = new int[8];
        digital = new byte[16];
        allocateMemory();
    }

    public void initialize() {
        for (int i = 0; i < analog.length; i++) {
            analog[i] = 32767; //1
        }

        for (int i = 0; i < digital.length; i++) {
            digital[i] = 1;
        }
        super.write();
    }
}
