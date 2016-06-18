package com.home.lifx.message;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;

import java.io.InputStream;

/**
 * Created by Aaron D'souza on 6/12/2016.
 */
public abstract class LifxResponseMessage extends LifxMessage {

    public LifxResponseMessage(BAddress address) {
        super(address);
    }

    //   Override for incoming messages
    @Override
    public void fromInputStream(InputStream in)
            throws Exception
    {
        System.out.println("Inside fromInputStream");
        TypedInputStream ti = (TypedInputStream)in;

        // Frame
        size = ti.readUnsigned16();
        ti.readUnsigned16();
        source = ti.readUnsigned32();

        // Frame address
        target = ti.readSigned64();
        ti.readUnsigned32();
        ti.readUnsigned16();
        ti.readUnsigned8();
        ti.readUnsigned8();

        // Protocol header
        ti.readSigned64();
        messageType = swap((short) ti.readUnsigned16());
        ti.readUnsigned16();

        readPayload(ti);
    }

    public abstract void readPayload(TypedInputStream ti);

    @Override
    public int validateResponse(NMessage msg) throws Exception {
        return super.validateResponse(msg);
    }

    public Object getTag() { return nullTag; }
    public boolean isResponse() { return true; }
    public boolean isFragmentable() { return false; }
    public int getResponseTimeOut() { return 25000; }

}
