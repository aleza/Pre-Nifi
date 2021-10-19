package com.preNifi.demo.service;

import com.preNifi.demo.entity.BillingDetail;
import com.preNifi.demo.entity.BillingList;
import com.preNifi.demo.functions.Functions;

import java.util.ArrayList;

public class EntradaService {

    public void comienzo(){
        //String line = null;
        String entrada = "CTI000D 30-66328849-7  30663288497  23/05/19940202626/05/202127/05/2021S\n" +
                "RES010D 26/05/2021020262/1408975082REVIRIEGO MIGUEL ANGEL        32200424  MENCF \n" +
                "FAC040D Bonificación Plan Control América 31          0013019900-000000000130199-20\n" +
                "CLT000D 2/1408975082000000000055602 18/06/202119/07/2021VRC1408BYD 01\n" +
                "CLT000D 2/1302320013000000000085800 30/10/198501/05/1986VRC1439DTB 01administracion@mantemed.com";

        Functions functions = new Functions();
        ArrayList<BillingDetail> billingDetails = new ArrayList<BillingDetail>();
        BillingList billingList = new BillingList();

        int inicio = 0;
        int corte = entrada.indexOf("\n");
        String renglon = "";
        int despuesCodigo = 0;


        System.out.println("largo total " + entrada.length());
        System.out.println("corte " + corte);

        for (int i = 0; i < entrada.length(); i++) {

            BillingDetail billingDetail = new BillingDetail();

            try {
                renglon = entrada.substring(inicio, corte);
                inicio = corte + 1;
                corte = entrada.indexOf("\n", corte + 1);
            } catch (StringIndexOutOfBoundsException e) {
                renglon = entrada.substring(inicio, entrada.length());
                i = entrada.length();
            }
            //System.out.println("renglon " + renglon);
            if(renglon.contains("RES010D")){
                despuesCodigo = renglon.indexOf(" ");
                //System.out.println("A veeer " + renglon.substring(despuesCodigo, renglon.length()));
            }else if(renglon.contains("CTI000D")){
                despuesCodigo = renglon.indexOf(" ");
                //System.out.println("A veeer " + renglon.substring(despuesCodigo, renglon.length()));
            }else if(renglon.contains("FAC040D")){
                despuesCodigo = renglon.indexOf(" ");
                //System.out.println("A veeer " + renglon.substring(despuesCodigo, renglon.length()));
            }else if(renglon.contains("CLT000D")){
                despuesCodigo = renglon.indexOf(" ");
                //functions.getCLT000DValues(renglon, billingDetail, despuesCodigo);
                System.out.println(functions.getCLT000DValues(renglon, billingDetail, despuesCodigo));
            }
            billingDetails.add(billingDetail);
        }

        billingList.setBillingDetails(billingDetails);
        System.out.println("ARchivo lista : " + billingList);

    }


}
