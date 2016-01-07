package com.c3i.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.c3i.json.JSONArray;
import com.c3i.json.JSONObject;
import com.c3i.utils.DBUtils;



public class GetStatisticsInfoModel
{
  
   
    /**
     * 执行查找StatisticsInfo方法并转换成json
     * lindi
     * @param 无
     * @return 转化后的json内容
     */
    public JSONArray getStatisticsInfo()
    {
        Connection conn = DBUtils.INSTANCE.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        JSONObject jsonObj = null;
        JSONArray jsonArr = new JSONArray();
        
        StringBuilder sqlCmd = new StringBuilder();
        sqlCmd.append("select count(*) as 总数，");
        sqlCmd.append(" sum(case when j.bjlbdm=010000 then 1 else 0 end) as 刑事警情,");
        sqlCmd.append(" sum(case when j.bjlbdm=020000 then 1 else 0 end) as 行政警情,");
        sqlCmd.append(" sum(case when j.bjlbdm=030000 then 1 else 0 end) as 交通警情,");
        sqlCmd.append(" sum(case when j.bjlbdm=040000 then 1 else 0 end) as 火灾事故,");
        sqlCmd.append(" sum(case when j.bjlbdm=050000 then 1 else 0 end) as 群众求助,");
        sqlCmd.append(" sum(case when j.bjlbdm=060000 then 1 else 0 end) as 举报投诉,");
        sqlCmd.append(" sum(case when j.bjlbdm=070000 then 1 else 0 end) as 事件,");
        sqlCmd.append(" sum(case when j.bjlbdm=080000 then 1 else 0 end) as 纠纷");
        sqlCmd.append(" from jxs_jjdb j");
        try
        {
            psmt = conn.prepareStatement(sqlCmd.toString());
            rs = psmt.executeQuery();
            
            while(rs.next())
            {
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "刑事警情");
                jsonObj.element("statistic", rs.getInt("刑事警情"));
                jsonArr.add(jsonObj);
                
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "行政警情");
                jsonObj.element("statistic", rs.getInt("行政警情"));
                jsonArr.add(jsonObj);

                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "交通警情");
                jsonObj.element("statistic", rs.getInt("交通警情"));
                jsonArr.add(jsonObj);
                
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "火灾事故");
                jsonObj.element("statistic", rs.getInt("火灾事故"));
                jsonArr.add(jsonObj);
                
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "群众求助");
                jsonObj.element("statistic", rs.getInt("群众求助"));
                jsonArr.add(jsonObj);
                
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "举报投诉");
                jsonObj.element("statistic", rs.getInt("举报投诉"));
                jsonArr.add(jsonObj);
                
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "事件");
                jsonObj.element("statistic", rs.getInt("事件"));
                jsonArr.add(jsonObj);
                
                jsonObj = new JSONObject();
                jsonObj.element("statisticsItem", "纠纷");
                jsonObj.element("statistic", rs.getInt("纠纷"));
                jsonArr.add(jsonObj);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtils.INSTANCE.closeDB(conn, psmt, rs);
        }
        
        return jsonArr;
    }
}
