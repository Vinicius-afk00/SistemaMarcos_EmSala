/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author u08538003160
 */
public class Conversor {
    
    public static Date TextoToDate(String textoData){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);// impede datas inváçidas
        
        try{
            java.util.Date dataUtil = sdf.parse(textoData);
            return new Date(dataUtil.getTime());
        }catch(ParseException e){
            return null;
        }
    }
    
}
