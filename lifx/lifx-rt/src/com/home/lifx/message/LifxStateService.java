package com.home.lifx.message;

import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.io.TypedInputStream;

/**
 * Created by Aaron D'souza on 6/12/2016.
 */
public class LifxStateService extends LifxDeviceResponseMessage {
    public LifxStateService(BAddress address) {
        super(address);
        setIpAddress(((BIpAddress)address).getIpAddress());
    }

    public LifxStateService() {
        super(new BIpAddress());
    }

    @Override
    public void readPayload(TypedInputStream ti) {
        setService(ti.readUnsigned8());
        byte[] bytes = new byte[]{(byte) ti.readUnsigned8(), (byte) ti.readUnsigned8(), (byte) ti.readUnsigned8(), (byte) ti.readUnsigned8()};
        long value = 0;
        for (int i = 0; i < bytes.length; i++) {
            value += ((long) bytes[i] & 0xffL) << (8 * i);
        }
        setPort(value);
    }

    private int service = 0; // Service number. UDP=1. 8-bit
    private long port = 0; // Port number. 32 bit
    private String ipAddress = ""; // Device IP address

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public long getPort() {
        return port;
    }

    public void setPort(long port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
