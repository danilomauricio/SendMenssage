package com.brenohff.projetoISO;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.channel.PADChannel;
import org.jpos.iso.channel.PostChannel;
import org.jpos.iso.channel.VAPChannel;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.iso.packager.ISO87APackager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ISOMain {

    public static void main(String[] args) {
        ISOMain classeTeste = new ISOMain();

        
            classeTeste.execute(classeTeste.debitoVisa());
        
    }

    private void execute(ISOMsg isoMsg) {
      try {
        	
 
            //GenericPackager packager = new GenericPackager("C:/Users/danilo.silva/Documents/Pakages/cfg/packager/iso87ebcdic_master.xml");
            //ASCIIChannel channel = new ASCIIChannel("localhost", 9898, packager);

            GenericPackager packager = new GenericPackager("C:/Users/danilo.silva/Documents/JPOS/pacote teste/cfg/packager/base1_2010.xml");
            VAPChannel channel = new VAPChannel("localhost", 6666, packager);
//
////            GenericPackager packager = new GenericPackager("C:/Users/danilo.silva/Documents/JPOS/pacote teste/cfg/packager/iso87ebcdic_master.xml");
////           PostChannel channel = new PostChannel("localhost", 3333, packager);
//        	
//         //Débito
////         GenericPackager packager = new GenericPackager("C:/Users/danilo.silva/Documents/JPOS/pacote teste/cfg/packager/iso87ebcdic-maestro.xml");
////         PostChannel channel = new PostChannel("localhost", 4444, packager);
//           
//        	//TEcban
//           GenericPackager packager = new GenericPackager("C:/Users/danilo.silva/Documents/JPOS/pacote teste/cfg/packager/iso87ascii_tecban.xml");
 //          PADChannel channel = new PADChannel("localhost", 15000, packager);

            channel.connect();
            channel.setTimeout(200000);
            channel.send(isoMsg);
            System.out.println("#############################  ISOMSG SENDED  #############################");
            isoMsg.dump(System.out, "");
            System.out.println(isoMsg);
           

            ISOMsg m = channel.receive();
            System.out.println("############################# ISOMSG RECEIVED #############################");
            m.dump(System.out, "");
            
         
            channel.disconnect();
        } catch (ISOException | IOException e) {
            e.printStackTrace();
        }
    }

    private ISOMsg Maestro() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0,"0200");
        isoMsg.set(2,"5127070037740834");
        isoMsg.set(3,"000000");
        isoMsg.set(4,"000000002515");
        isoMsg.set(5,"000000002515");
        isoMsg.set(6,"000000002515");
        isoMsg.set(7,"1021180525");
        isoMsg.set(9,"61000000");
        isoMsg.set(10,"61000000");
        isoMsg.set(11,"123322");
        isoMsg.set(12,"150525");
        isoMsg.set(13,"1021");
        isoMsg.set(15,"1021");
        isoMsg.set(16,"1020");
        isoMsg.set(18,"5462");
        isoMsg.set(22,"051");
        isoMsg.set(23,"002");
        isoMsg.set(32,"998653213");
        isoMsg.set(33,"9000000532");
        isoMsg.set(35,"5127070037740834=23032014200000000000");
        isoMsg.set(37,"3932858     ");
        isoMsg.set(41,"WY456527");
        isoMsg.set(42,"044906722      ");
        isoMsg.set(43,"CEMAR PAES E CONVENIEN BRASILIA      BRA");
        isoMsg.set(48,"R");
        isoMsg.set(49,"986");
        isoMsg.set(50,"986");
        isoMsg.set(51,"986");
        isoMsg.set(55,"37333031303037303832303231383030394633363032303436303946323630383931393246383135443641413230453039463130313230303130413030303033323230303030303030303030303030303030303030303030464639463032303630303030303030303030303039463033303630303030303030303030303039463141303230303736393530353830303030343030303035463241303230393836394130333230303831373943303133303946333730344631373131383042394633353031313439463435303230303030394633343033303230303030394633333033363034304330");
        isoMsg.set(61,"000000000030107672015535  ");
        isoMsg.set(63,"MS2579141007");
        isoMsg.set(110,"0803MSI");
        isoMsg.set(126,"006P7E009HISFNX                                   ");
        return isoMsg;
    }

    private ISOMsg setTA() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0100");
        isoMsg.set(2, "5127070152624003");
        isoMsg.set(3, "000000");
        isoMsg.set(4, "000000000000");
        isoMsg.set(6, "000000000000");
        isoMsg.set(7, "1204045125");
        isoMsg.set(10, "61000000");
        isoMsg.set(11, "000002");
        isoMsg.set(12, "045125");
        isoMsg.set(13, "1204");
        isoMsg.set(14, "2108");
        isoMsg.set(15, "1204");
        isoMsg.set(16, "1204");
        isoMsg.set(18, "5969");
        isoMsg.set(22, "010");
        isoMsg.set(32, "015611");
        isoMsg.set(33, "022020");
        isoMsg.set(37, "080114700053");
        isoMsg.set(41, "12345678");
        isoMsg.set(42, "CARD ACCPT IDC ");
        isoMsg.set(43, "Other Marketing        Vegas         NV ");
        isoMsg.set(48, "T230201260310333260101C0611012345678900802048202529203946");
        isoMsg.set(49, "840");
        isoMsg.set(51, "840");
        isoMsg.set(61, "203110900000084063368");
        isoMsg.set(63, "MCC0110RH");
        isoMsg.set(120, "011863110    1520 Main");
        isoMsg.set(124,
                "TA1234567890123431234567890ABCDEFGHIJ1234567890ABCDEFGHIJ        12345ABCDE  1234567890123456ABCDEFGHIJKLMNOP                                LASTNAME/FIRSTNAME         09954001234561A2B3C4D11234S");

        return isoMsg;
    }
    
    private ISOMsg consultaTecban() {
    	ISOMsg isoMsg = new ISOMsg();
        isoMsg.set(0,"9000");
        isoMsg.set(3,"302000");
        isoMsg.set(7,"0817070437");
        isoMsg.set(11,getNsu());
        isoMsg.set(12,"040437");
        isoMsg.set(13,"0817");
        isoMsg.set(22,"051");
        isoMsg.set(23,"002");
        isoMsg.set(32,"00051270700");
        isoMsg.set(35,"5127070037740834=23032014200000000000");
        isoMsg.set(41,"00060007");
        isoMsg.set(42,"000000003019803");
//        isoMsg.set(55,"37333031303037303832303231383030394633363032303436303946323630383931393246383135443641413230453"
//        		+ "0394631303132303031304130303030333232303030303030303030303030303030303030303030304646394630323036303030303030303030303030"
//        		+ "3946303330363030303030303030303030303946314130323030373639353035383030303034303030303546324130323039383639413033323030383"
//        		+ "1373943303133303946333730344631373131383042394633353031313439463435303230303030394633343033303230303030394633333033363034304330");
        isoMsg.set(55,"73010070820218009F360204609F26089192F815D6AA20E09F10120010A00003220000000000000000000"
        		+ "000FF9F02060000000000009F03060000000000009F1A020076950580000400005F2A0209869A032008179C01309F3704F171180B9F3501149F450200009F34030200009F33036040C0");
        isoMsg.set(61,"C10451008");
        
        return isoMsg;
    }

    private ISOMsg debitoTecban() {
    	ISOMsg isoMsg = new ISOMsg();
        isoMsg.set(0,"0200");
        isoMsg.set(3,"012000");
        isoMsg.set(4,"000000015000");
        isoMsg.set(7,"0819181050");
        isoMsg.set(11,"382979");
        isoMsg.set(12,"151050");
        isoMsg.set(13,"0819");
        isoMsg.set(15,"0819");
        isoMsg.set(22,"051");
        isoMsg.set(23,"000");
        isoMsg.set(32,"00046606900");
        isoMsg.set(35,"5127070037740834=20092014200000000000");
        isoMsg.set(37,"000235200819");
        isoMsg.set(41,"00035213");
        isoMsg.set(42,"000000003019803");
        isoMsg.set(49,"076");
        isoMsg.set(55,"73010070820218009F360204609F26089192F815D6AA20E09F10120010A00003220000000000000000000"
        		+ "000FF9F02060000000000009F03060000000000009F1A020076950580000400005F2A0209869A032008179C01309F3704F171180B9F3501149F450200009F34030200009F33036040C0");      
        isoMsg.set(61,"C10451008");
        
        return isoMsg;
    }
    
    private ISOMsg consultaTecbanVISA() {
    	ISOMsg isoMsg = new ISOMsg();
        isoMsg.set(0,"9000");
        isoMsg.set(3,"302000");
        isoMsg.set(7,"0817070437");
        isoMsg.set(11,getNsu());
        isoMsg.set(12,"040437");
        isoMsg.set(13,"0817");
        isoMsg.set(22,"051");
        isoMsg.set(23,"002");
        isoMsg.set(32,"00051270700");
        isoMsg.set(35,"5158940030044289=21062014200000000000");
        isoMsg.set(41,"00060007");
        isoMsg.set(42,"000000003019803");
        isoMsg.set(55,"364530323030364235463241303230383430383230323538303038343037413030303030303030343130313039353035303030303030303030303941303332303036303439433031303039463032303630303030303030303130303039463130313230303130323530303030303434303030444143313030303030303030303030303030303039463141303230383430394632363038424541443034394643334436443434383946323730313830394633333033453045384538394633343033343130333032394633363032313939353946333730343237424137463843");
//        isoMsg.set(55,"73010070820218009F360204609F26089192F815D6AA20E09F10120010A00003220000000000000000000"
//        		+ "000FF9F02060000000000009F03060000000000009F1A020076950580000400005F2A0209869A032008179C01309F3704F171180B9F3501149F450200009F34030200009F33036040C0");
        isoMsg.set(61,"C10451008");
        
        return isoMsg;
    }

    private ISOMsg visaDebitoTecban() {
    	ISOMsg isoMsg = new ISOMsg();
        isoMsg.set(0,"0200");
        isoMsg.set(3,"012000");
        isoMsg.set(4,"000000015000");
        isoMsg.set(7,"0819181050");
        isoMsg.set(11,"382979");
        isoMsg.set(12,"151050");
        isoMsg.set(13,"0819");
        isoMsg.set(15,"0819");
        isoMsg.set(22,"051");
        isoMsg.set(23,"000");
        isoMsg.set(32,"00046606900");
        isoMsg.set(35,"4660700000047079=21062014200000000000");
        isoMsg.set(37,"000235200819");
        isoMsg.set(41,"00035213");
        isoMsg.set(42,"000000003019803");
        isoMsg.set(49,"076");
        isoMsg.set(55,ISOUtil.hex2byte("73010070 820218009F360204609F26089192F815D6AA20E09F10120010A00003220000000000000000000"
        		+ "000FF9F02060000000000009F03060000000000009F1A020076950580000400005F2A0209869A032008179C01309F3704F171180B9F3501149F450200009F34030200009F33036040C0"));   
        isoMsg.set(61,"C10451008");
        
        return isoMsg;
    }
    private ISOMsg setAC() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0100");
        isoMsg.set(2, "5127070152624003");
        isoMsg.set(3, "000000");
        isoMsg.set(4, "000000000000");
        isoMsg.set(6, "000000000000");
        isoMsg.set(7, "1204093822");
        isoMsg.set(10, "61000000");
        isoMsg.set(11, "000003");
        isoMsg.set(12, "093822");
        isoMsg.set(13, "1204");
        isoMsg.set(14, "2108");
        isoMsg.set(15, "1204");
        isoMsg.set(16, "1204");
        isoMsg.set(18, "5969");
        isoMsg.set(22, "010");
        isoMsg.set(32, "015611");
        isoMsg.set(33, "022020");
        isoMsg.set(37, "080114600061");
        isoMsg.set(41, "12345678");
        isoMsg.set(42, "CARD ACCPT IDC ");
        isoMsg.set(43, "Other Marketing        Vegas         NV ");
        isoMsg.set(48, "T230201260310333200101C0611012345678909203802");
        isoMsg.set(49, "840");
        isoMsg.set(51, "840");
        isoMsg.set(61, "203110900000084063368");
        isoMsg.set(63, "MCC0110S6");
        isoMsg.set(124, "AC12345678901234123456  18123111111(232323) 232323 4567 &amp;239474;");

        return isoMsg;
    }

    private ISOMsg debitoVisa() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0100");
        isoMsg.set(2, "4473980001741381");
        isoMsg.set(3, "010000");
        isoMsg.set(4, "000000002500");
        isoMsg.set(7, getTimeStamp());
        isoMsg.set(11, getNsu());
        isoMsg.set(14, "2106");
        isoMsg.set(18, "9701");
        isoMsg.set(19, "076");
        isoMsg.set(22, "010");
        isoMsg.set(25, "00");
        isoMsg.set(32, "419895");
        isoMsg.set(37, "915718000906");
        isoMsg.set(41, "TERMID01");
        isoMsg.set(42, "CARTAO TESTE   ");
        isoMsg.set(43, "APAG*Car3efourApag       S3o Pa3lo    BR");
        isoMsg.set(49, "986");
        isoMsg.set(60, ISOUtil.hex2byte("0900080005"));
        isoMsg.set(62, ISOUtil.hex2byte("0000000000000000"));
        isoMsg.set(63, ISOUtil.hex2byte("8000000002"));
       // isoMsg.set(104, ISOUtil.hex2byte("56001E010B3030303130303737393339020F303030303030303030303832323233"));
        

        return isoMsg;

    }

    private ISOMsg creditoVisa() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0100");
        isoMsg.set(2, "4473980001741381");
        isoMsg.set(3, "110000");
        isoMsg.set(4, "000000005500");
        isoMsg.set(7, getTimeStamp());
        isoMsg.set(11, getNsu());
        isoMsg.set(18, "6051");
        isoMsg.set(19, "840");
        isoMsg.set(22, "900");
        isoMsg.set(25, "00");
        isoMsg.set(32, "12345678901");
        isoMsg.set(35, "4473980001741381=21062016780000000000");
        isoMsg.set(37, "915813000003");
        isoMsg.set(41, "TERMID01");
        isoMsg.set(42, "CARD ACCEPTOR  ");
        isoMsg.set(49, "986");
        isoMsg.set(60, ISOUtil.hex2byte("0907080005"));
        isoMsg.set(62, ISOUtil.hex2byte("0000000000000000"));
        isoMsg.set(63, ISOUtil.hex2byte("8400000002F0F0F0F0F0F0F7"));

        return isoMsg;
    }

    private ISOMsg creditoMaster() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0100");
        isoMsg.set(2, "5197047000055601");
        isoMsg.set(3, "000000");
        isoMsg.set(4, "000000000004");
        isoMsg.set(6, "000000009391");
        isoMsg.set(7, getTimeStamp());
        isoMsg.set(10, "62347711");
        isoMsg.set(11, getNsu());
        isoMsg.set(12, "141217");
        isoMsg.set(13, "0606");
        isoMsg.set(14, "1908");
        isoMsg.set(15, "0606");
        isoMsg.set(16, "0606");
        isoMsg.set(18, "5045");
        isoMsg.set(22, "810");
        isoMsg.set(32, "009685");
        isoMsg.set(42, "ID-Code02      ");
        isoMsg.set(43, "Ecom01                 St. Louis     MO ");
        isoMsg.set(48, "T");
        isoMsg.set(49, "978");
        isoMsg.set(51, "986");
        isoMsg.set(61, "102510000610084090210");
        isoMsg.set(63, "MCC0110VZ");

        return isoMsg;
    }

    private ISOMsg setStandin() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0120");
        isoMsg.set(2, "5158940030044289");
        isoMsg.set(3, "000000");
        isoMsg.set(4, "000000001000");
        isoMsg.set(6, "000000001954");
        isoMsg.set(7, getTimeStamp());
        isoMsg.set(10, "61954000");
        isoMsg.set(11, getNsu());
        isoMsg.set(12, "135152");
        isoMsg.set(13, "0529");
        isoMsg.set(15, "0529");
        isoMsg.set(16, "0529");
        isoMsg.set(18, "5999");
        isoMsg.set(22, "900");
        isoMsg.set(23, "000");
        isoMsg.set(32, "009685");
        isoMsg.set(35, "5158940030044289D2203101010001");
        isoMsg.set(37, "123456789012");
        isoMsg.set(38, "005366");
        isoMsg.set(39, "00");
        isoMsg.set(41, "Reg00004");
        isoMsg.set(42, "687555537877464");
        isoMsg.set(43, "Midwest Emporium       Columbia      MO ");
        isoMsg.set(48, "R");
        isoMsg.set(49, "840");
        isoMsg.set(51, "986");
        isoMsg.set(60, "2030000");
        isoMsg.set(61, "0000000002000840123");
        isoMsg.set(63, "MCC01106Y");

        return isoMsg;
    }

    private String getNsu() {
        Random random = new Random();
        String nsu = String.format("%06d", random.nextInt(999999));

        return nsu;
    }

    private String getTimeStamp() {
        SimpleDateFormat dt = new SimpleDateFormat("ddMMHHmmss");
        dt.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        return dt.format(c.getTime());
    }
    
    private ISOMsg cabalDebito() {
        ISOMsg isoMsg = new ISOMsg();

        isoMsg.set(0, "0200");
        isoMsg.set(2, "6042034500626136");
        isoMsg.set(3, "002000");
        isoMsg.set(4, "000000001601");
        isoMsg.set(7,   getTimeStamp());
        isoMsg.set(11,  getNsu());
        isoMsg.set(12, "093822");
        isoMsg.set(13, "0227");
        isoMsg.set(18, "5812");
        isoMsg.set(22, "051");
        isoMsg.set(32, "00000000006");
        isoMsg.set(33, "00000000006");
        isoMsg.set(35, "6042034500626136=21082015950000000000");        
        isoMsg.set(37, "905402801240");
        isoMsg.set(41, "PCCN1234");
        isoMsg.set(42, "19880768000125");
        isoMsg.set(43, "NOME DO COMERCIO                        ");
        isoMsg.set(48, "0103101121422211044000101");      
        isoMsg.set(49, "986");
        isoMsg.set(55, "9F2608CF4D7CCA185FC5AB9F10200FA501A03900140000000000000000000F02030203B8189630603800000000009F3602003D9F02060000000000909F03060000000000009F1A020076950540800000005F2A0209869A032002279C01009F37048470E07B5A0860420345006261365F340100820258009F2701808407A0000004421010");
        //isoMsg.set(55, "394632363038434634443743434131383546433541423946313032303046413530314130333930303134303030303030303030303030303030303030304630323033303230334238313839363330363033383030303030303030303039463336303230303344394630323036303030303030303030303930394630333036303030303030303030303030394631413032303037363935303534303830303030303030354632413032303938363941303332303032323739433031303039463337303438343730453037423541303836303432303334353030363236313336354633343031303038323032353830303946323730313830383430374130303030303034343231303130");
        isoMsg.set(61, "000900003000760000000000");
        isoMsg.set(63, "CB120200905402801240");
        
        return isoMsg;
    }

}