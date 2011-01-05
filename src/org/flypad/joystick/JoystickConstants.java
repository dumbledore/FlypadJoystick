/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.flypad.joystick;

/**
 *
 * @author albus
 */
public interface JoystickConstants {
    public static final int ANALOG_MIN          = 1;
    public static final int ANALOG_MAX          = 32767;
    public static final int ANALOG_MID          = 16384;
    public static final int ANALOG_DEFAULT      = ANALOG_MID;

    public static final int ANALOG_AXIS_X       = 0;
    public static final int ANALOG_AXIS_Y       = 1;
    public static final int ANALOG_AXIS_Z       = 2;
    public static final int ANALOG_ROTATION_X   = 5;
    public static final int ANALOG_ROTATION_Y   = 6;
    public static final int ANALOG_ROTATION_Z   = 3;
    public static final int ANALOG_SLIDER       = 4;
    public static final int ANALOG_DIAL         = 7;

    public static final byte DIGITAL_OFF        = 0;
    public static final byte DIGITAL_ON         = 1;

    public static final byte NUM_ANALOG         = 8;
    public static final byte NUM_DIGITAL        = 16;
}
