package com.home.lifx.message;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

/**
 * Created by Aaron D'souza on 6/12/2016.
 */
public class LifxMessage extends NMessage {
    public LifxMessage(BAddress address){super(address);}

    protected short swap (short value)
    {
        int b1 = value & 0xff;
        int b2 = (value >> 8) & 0xff;

        return (short) (b1 << 8 | b2 << 0);
    }

    public int swap (int value)
    {
        int b1 = (value >>  0) & 0xff;
        int b2 = (value >>  8) & 0xff;
        int b3 = (value >> 16) & 0xff;
        int b4 = (value >> 24) & 0xff;

        return b1 << 24 | b2 << 16 | b3 << 8 | b4 << 0;
    }

    public  long swap (long value)
    {
        long b1 = (value >>  0) & 0xff;
        long b2 = (value >>  8) & 0xff;
        long b3 = (value >> 16) & 0xff;
        long b4 = (value >> 24) & 0xff;
        long b5 = (value >> 32) & 0xff;
        long b6 = (value >> 40) & 0xff;
        long b7 = (value >> 48) & 0xff;
        long b8 = (value >> 56) & 0xff;

        return b1 << 56 | b2 << 48 | b3 << 40 | b4 << 32 |
                b5 << 24 | b6 << 16 | b7 <<  8 | b8 <<  0;
    }
    private static final long RASPBERRY_PI_ZERO = 0xAAAAAAAA;
    /*Header*/
    // Frame
    public int size = 0; // 16 bits. Size of entire message in bytes including this field
    public int origin = 0; // 2 bits. Message origin indicator: Must be 0
    public boolean tagged = false; // 1 bit. Determines usage of Frame Address target field
    public int addressable = 1; // 1 bit. Message includes a target address: must be one (1)
    public int protocol = 1024; // 12 bits. Protocol number: must be 1024 (decimal)
    public long source = RASPBERRY_PI_ZERO; // 32 bits. Source identifier: unique value set by the client, used by responses

    // Frame Address
    public long target = 0L; // 64 bits. 6 byte device address (MAC address) or zero (0) means all devices
    public long reserved1 = 0L; // 48 bits. Array of bytes; length 6. Must all be zero (0)
    public int reserved2 = 0; // 6 bits. Reserved
    public boolean ackRequired = false; // 1 bit. Acknowledgement message required
    public boolean responseRequired = false; // 1 bit. Response message required
    public int sequence = 0; // 8 bits. Wrap around message sequence number

    // Protocol Header
    public long reserved3 = 0; // 64 bits. Reserved
    public int messageType = 0; // 16 bits. Message type determines the payload being used
    public int reserved4 = 0; // 16 bits. Reserved
}
