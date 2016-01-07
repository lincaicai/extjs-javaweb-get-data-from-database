package com.c3i.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.c3i.model.GetStatisticsInfoModel;

public class StatisticsInfoService extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

   
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        GetStatisticsInfoModel staInfo = new GetStatisticsInfoModel();
        out.print(staInfo.getStatisticsInfo());
        
        out.flush();
        out.close();
    }

}