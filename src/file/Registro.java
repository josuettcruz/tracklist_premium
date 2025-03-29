/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Registro {
    
    public static String Title(String text, String separator){
        
        boolean ifo = false;
        
        String txt = "";
        
        String document_text[] = text.split(" ");
        
        List<String> document = new ArrayList<>();
        
        for(String ds : document_text){
            
            String table = ds.replaceAll("\'", "").replaceAll("\"", "");
            
            if(table.contains("/")){
                
                String inline[] = table.split("/");
                
                for(String ins : inline){
                    
                    if(!ins.isBlank()){
                        
                        document.add(ins);
                        
                    }//if(!ins.isBlank())
                    
                }//for(String ins : inline)
                
            } else if(table.contains("&")){
                
                String inline[] = table.split("&");
                
                for(String ins : inline){
                    
                    if(!ins.isBlank()){
                        
                        document.add(ins);
                        
                    }//if(!ins.isBlank())
                    
                }//for(String ins : inline)
                
            } else if(table.contains("-")){
                
                String inline[] = table.split("-");
                
                for(String ins : inline){
                    
                    if(!ins.isBlank()){
                        
                        document.add(ins);
                        
                    }//if(!ins.isBlank())
                    
                }//for(String ins : inline)
                
            } else if(table.contains("_")){
                
                String inline[] = table.split("_");
                
                for(String ins : inline){
                    
                    if(!ins.isBlank()){
                        
                        document.add(ins);
                        
                    }//if(!ins.isBlank())
                    
                }//for(String ins : inline)
                
            } else if(table.contains("&")){
                
                String inline[] = table.split("&");
                
                for(String ins : inline){
                    
                    if(!ins.isBlank()){
                        
                        document.add(ins);
                        
                    }//if(!ins.isBlank())
                    
                }//for(String ins : inline)
                
            } else if(table.length() > 0){
                
                document.add(table);
                
            }//if(ds.length() > 0)
            
        }//for(String ds : document_text)
        
        for(int x = 0; x < document.size(); x++){
            
            boolean select;
            
            if(x == 0){
                
                select = true;
                
            } else {//if(x == 0)
                
                txt += " ";
                
                switch(document.get(x).toLowerCase()){
                    
                    case "se":
                    case "no":
                    case "na":
                    case "do":
                    case "de":
                    case "da":
                    case "dos":
                    case "das":
                    case "nós":
                    case "nos":
                    case "nas":
                    case "aos":
                    case "lhe":
                    case "lhes":
                    case "lha":
                    case "lhas":
                    case "ao":
                    case "os":
                    case "as":
                    case "ás":
                    case "às":
                    txt += document.get(x).toLowerCase();
                    select = false;
                    break;

                    default:
                    select = true;
                    break;

                }//switch(document.get(x).toLowerCase())
                
            }//if(x == 0)
            
            if(document.get(x).contains("[") || document.get(x).contains("(") || document.get(x).contains("{")){
                
                txt += separator;
                
                txt += "[";
                
                ifo = true;
                
            }
            
            //select == true;
            
            if(ifo){
                
                String dote = "";
                
                boolean dao = true;
                
                for(int p = 0; p < document.get(x).length(); p++){
                    
                    switch(document.get(x).charAt(p)){
                        
                        case '[':
                        case '(':
                        case '{':
                        case ']':
                        case ')':
                        case '}':
                        if(p > 1){dote += " ";}
                        dao = false;
                        break;
                        
                        case ' ':
                        if(p > 1 && dao){dote += " ";dao = false;}
                        break;
                        
                        default:
                        dote += document.get(x).charAt(p);
                        dao = true;
                        break;
                        
                    }
                    
                }//for(int p = 0; p < document.get(x).length(); p++)

                txt += dote.toUpperCase();
            
            } else if(select){//if(ifo)
            
                switch(document.get(x).length()){

                    case 1 ->{

                        if(x == 0){
                            txt += document.get(x).toUpperCase();
                        } else {
                            txt += document.get(x).toLowerCase();
                        }

                    }//case 1

                    default ->{

                        for(int y = 0; y < document.get(x).length(); y++){

                            String dg = document.get(x).charAt(y) + "";

                            if(y == 0){
                                txt += dg.toUpperCase();
                            } else {
                                txt += dg.toLowerCase();
                            }

                        }//for(int i = 0; i < ds.length(); i++)

                    }//default

                }//switch(ds.length())

            }//for(String ds : document)
            
        }//if(select)
        
        if(ifo){
            txt += "]";
        }
        
        return txt;
        
    }//Title(String text)
    
    /*public static String Select(String text, String opc, int max){
        
        boolean word_null = true;
        int letter = 0;
        
        String txt = "";
        
        String space[] = text.split(" ");
        
        List<String> doc = new ArrayList<>();
        
        for(String sp : space){if(sp.length() > 1){doc.add(sp);}}
        
        for(int i = 0; i < doc.size(); i++){
            
            letter = letter + doc.get(i).length();
            
            if(i > 0){
                txt += " ";
            }
            
            if(letter <= max){
                
                txt += doc.get(i);
                word_null = false;
                
            } else if(word_null){//if(letter <= max)
                
                int dig = max - letter;
                
                txt += doc.get(i).substring(0, dig);
                txt += "...";
                break;
                
            } else {//if(letter <= max)
                
                txt += "...";
                break;
                
            }//if(letter <= max)
            
        }//for(int i = 0; i < doc.size(); i++)
        
        if(text.trim().isBlank()){
            return opc.trim();
        } else {
            return txt;
        }
        
    }/*Select(String text, String opc, int max)*/
    
    public static String Select(String text, int max){
        
        boolean word_null = true;
        int letter = 0;
        
        String txt = "";
        
        String space[] = text.split(" ");
        
        List<String> doc = new ArrayList<>();
        
        for(String sp : space){if(!sp.isBlank()){doc.add(sp);}}
        
        for(int i = 0; i < doc.size(); i++){
            
            letter = letter + doc.get(i).length();
            
            if(letter <= max){
                
                if(i > 0){txt += " ";}
                
                txt += doc.get(i);
                word_null = false;
                
            } else if(word_null){//if(letter <= max)
                
                int dig = max - letter;
                
                txt += doc.get(i).substring(0, dig);
                txt += "...";
                break;
                
            } else {//if(letter <= max)
                
                txt += "...";
                break;
                
            }//if(letter <= max)
            
        }//for(int i = 0; i < doc.size(); i++)
        
        return txt;
        
    }//Select(String text, int max)
    
}