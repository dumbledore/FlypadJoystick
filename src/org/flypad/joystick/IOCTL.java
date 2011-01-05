/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.flypad.joystick;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.examples.win32.W32API.HANDLE;
import com.sun.jna.examples.win32.W32API.WORD;
import com.sun.jna.win32.StdCallLibrary;

/**
 *
 * @author albus
 */
public interface IOCTL extends StdCallLibrary {
    IOCTL INSTANCE = (IOCTL) Native.loadLibrary("kernel32", IOCTL.class);
    
//    BOOL WINAPI DeviceIoControl(
//      __in         HANDLE hDevice,
//      __in         DWORD dwIoControlCode,
//      __in_opt     LPVOID lpInBuffer,
//      __in         DWORD nInBufferSize,
//      __out_opt    LPVOID lpOutBuffer,
//      __in         DWORD nOutBufferSize,
//      __out_opt    LPDWORD lpBytesReturned,
//      __inout_opt  LPOVERLAPPED lpOverlapped
//    );
    public int DeviceIoControl(
            HANDLE hDevice,         //h
            int    dwIoControlCode, //0x220000
            Structure lpInBuffer,   //JoystickState
            int    nInBufferSize,   //sizeof(JoystickState)
            Pointer lpOutBuffer,    //null
            int     nOutBufferSize, //0
            Pointer    lpBytesReturned,//&RetSize (a dword reference!)
            Pointer lpOverlapped    //null
            );

    public int GetLastError();
}
