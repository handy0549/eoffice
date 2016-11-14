package com.arifin.helper;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by arifin on 12/11/16.
 */
@Component("ToSql")
public class ToSql {

    public static final String PER_PAGE = "1";

    public String Where(String Paren, Map<String,String> param,String index, Boolean page)
    {

        String Sql="";
        String Output="";

        String Paging=null;

        for (Map.Entry<String, String> entry : param.entrySet())
        {
            if(entry.getKey().equalsIgnoreCase("page"))
            {
                Paging = entry.getValue();
            }
            else
            {
                System.out.println(entry.getKey() + "sds/" + entry.getValue());
                Sql+=" and " +index + "." +entry.getKey() + "= '" + entry.getValue() + "' ";
            }

        }
        if( page ==true && Paging != null)
        {
            Sql+=" and rownum <= (" + PER_PAGE + " + " + Paging + ")  ";
            Output = "Select * from ( " + Paren + Sql + " )" +
                    " where rn > "+ Paging +"";

        }
        else
        {
            Output=Paren;
            Output+=Sql;

        }
        return Output;
    }


}
