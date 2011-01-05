/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.flypad.joystick.jna;

import com.sun.jna.Structure;
import org.flypad.joystick.Joystick;

/**
 *
 * @author albus
 */
public class JoystickState extends Structure {
    /* Signature to identify packet to PPJoy IOCTL */
    public int signature = 0x53544143;
    /* Num of analog values we pass */
    public byte numAnalog = Joystick.NUM_ANALOG;
    /* Analog values */
    public int[] analog = new int[Joystick.NUM_ANALOG];
    /* Num of digital values we pass */
    public byte numDigital = Joystick.NUM_DIGITAL;
    /* Digital values */
    public byte[] digital = new byte[Joystick.NUM_DIGITAL];

    {
        setAlignType(ALIGN_NONE);
    }
}
