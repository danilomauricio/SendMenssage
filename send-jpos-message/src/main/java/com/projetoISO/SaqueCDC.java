package com.projetoISO;

import java.io.IOException;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.PADChannel;
import org.jpos.iso.packager.GenericPackager;

public class SaqueCDC {

	   public static void main(String[] args) {
	        SaqueCDC classeTeste = new SaqueCDC();

	        
	            classeTeste.execute(classeTeste.SaqueCDC());
	        
	    }

	    private void execute(ISOMsg isoMsg) {
	        try {
      
	        	//TEcban
	           GenericPackager packager = new GenericPackager("C:/Users/danilo.silva/Documents/JPOS/pacote teste/cfg/packager/iso87ascii_webcab.xml");
	           PADChannel channel = new PADChannel("localhost", 5003, packager);

	            channel.connect();
	            channel.setTimeout(20000);
	            channel.send(isoMsg);

	            System.out.println("#############################  ISOMSG SENDED  #############################");
	            isoMsg.dump(System.out, "");
	            System.out.println(isoMsg);
	            System.out.println();

	            ISOMsg m = channel.receive();
	            System.out.println("############################# ISOMSG RECEIVED #############################");
	            m.dump(System.out, "");
	            

	            channel.disconnect();
	        } catch (ISOException | IOException e) {
	            e.printStackTrace();
	        }
	    }
	    

	    private ISOMsg SaqueCDC() {
	        ISOMsg isoMsg = new ISOMsg();
	        
	        String Tag012 ="012012000000001000";              // txMensal
	        String Tag013 ="013012000000002000";              // txtAnual
	        String Tag014 ="014012000000003000";              // cetAnual
	        String Tag015 ="015012000000001500";              // iofDiario
	        String Tag016 ="016012000000001100";              // iofAdic
	        String Tag017 ="017012000000001800";              // juroPrimParc
	        String Tag018 ="01800817112020";              // dtVencPrimParc
	        String Tag019 ="019012000000001900";              // txEmissor*/
	       
	        isoMsg.set(0,"0200");
	        isoMsg.set(2,"5474080152178461");
	        isoMsg.set(3,"013010");
	        isoMsg.set(4,"000000500000");
	        isoMsg.set(7,"0909105816");
	        isoMsg.set(11,"165810");
	        isoMsg.set(12,"105816");
	        isoMsg.set(13,"0909");
	        isoMsg.set(22,"012");
	        isoMsg.set(33,"805");
	        isoMsg.set(41,"756001");
	        isoMsg.set(42,"000099975631199");
	        isoMsg.set(43,"SAQUE CDC");
	        isoMsg.set(48, Tag012+ Tag013+Tag014+Tag015+Tag016+Tag017+Tag018+Tag019);
	        isoMsg.set(49,"076");
	        isoMsg.set(67,"05");
	        isoMsg.set(100,"805");
	        return isoMsg;
	    }

}
