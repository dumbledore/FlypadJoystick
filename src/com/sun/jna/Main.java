/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sun.jna;

import com.sun.jna.examples.win32.Kernel32;
import com.sun.jna.examples.win32.W32API.HANDLE;
import com.sun.jna.examples.win32.W32API.WORD;
import org.flypad.joystick.IOCTL;
import org.flypad.joystick.JoystickState;

/**
 *
 * @author albus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String devName= "\\\\.\\PPJoyIOCTL1";
        String devName= "\\\\.\\PPJoyIOCTL1";

        System.out.println("Opening handle...");
        
        HANDLE h = Kernel32.INSTANCE.CreateFile(
                devName,
                Kernel32.GENERIC_WRITE,
                Kernel32.FILE_SHARE_WRITE,
                null,
                Kernel32.OPEN_EXISTING,
                0,
                null);

        System.out.println("Handle opened!");
        System.out.println(h);

        JoystickState j = new JoystickState();
        j.setAlignType(Structure.ALIGN_NONE);
        j.initialize();
        j.ensureAllocated();

        final int size =
                Native.getNativeSize(JoystickState.class, j
                );
        System.out.println("struct size: " + size);

        WORD w = new WORD();

        System.out.println("RC: " + IOCTL.INSTANCE.GetLastError());

        System.out.println("Sending to joystick...");
        int res = IOCTL.INSTANCE.DeviceIoControl(
                h,
                0x220000,
                j,
                size,
                Pointer.NULL,
                0,
                j.getPointer(),//w,
                null//j.getPointer()
                );

        System.out.println("RES: " + res);
        System.out.println("RC: " + IOCTL.INSTANCE.GetLastError());

        try {
            System.out.println("sleeping...");
            Thread.sleep(5000);
        }
        catch (Exception e) {}

        System.out.println("Closing handle...");
        Kernel32.INSTANCE.CloseHandle(h);
        System.out.println("RC: " + IOCTL.INSTANCE.GetLastError());
        System.out.println("Handle closed!");
    }
}
