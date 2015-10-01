<%@ WebService Language="C#" Class="DaHongWa"  %>

using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Web;
using System.Web.Services;


[WebService(Namespace = "http://tempuri.org/")]  
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]

[System.ComponentModel.ToolboxItem(false)]
//若要允许使用 ASP.NET AJAX 从脚本中调用此 Web 服务，请取消对下行的注释。 
[System.Web.Script.Services.ScriptService]

public class DaHongWa : System.Web.Services.WebService 
{

    public DaHongWa()
    {
        // http://112.124.97.86:8282/WebServices/DaHongWa/DaHongWa.asmx
    }

    [WebMethod]
    public String CreateRawWayBill(String KeyCode, String OrderInfo)
    {
        //RawWayBill Bill = new RawWayBill();
        //Bill.KeyCode = KeyCode;
        //Bill.OrderInfo = OrderInfo;

        Trace.WriteLine(KeyCode, "Bill KeyCode");
        Trace.WriteLine(OrderInfo, "Bill OrderInfo");

        return "0";
    }

    [WebMethod]
    public string DeleteOrder(String KeyCode, String UniqueID)
    {
        Trace.WriteLine(KeyCode, "DeleteOrder KeyCode");
        Trace.WriteLine(UniqueID, "DeleteOrder UniqueID");

        return "0";
    }


    [WebMethod]
    public string SendIDCardInformation(Byte[] byteIDCardPic1, Byte[] byteIDCardPic2, String IDNumber, String KeyCode, String WBID)
    {
        
        Trace.WriteLine(IDNumber, "SendIDCardInformation KeyCode");
        Trace.WriteLine(KeyCode, "SendIDCardInformation UniqueID");
        Trace.WriteLine(WBID, "SendIDCardInformation WBID");

        System.IO.FileStream front = System.IO.File.OpenWrite(Server.MapPath(@"\" + "front.jpg"));
        System.IO.BinaryWriter frontWriter = new System.IO.BinaryWriter(front);
        System.IO.FileStream back = System.IO.File.OpenWrite(Server.MapPath(@"\" + "back.jpg"));
        System.IO.BinaryWriter backWriter = new System.IO.BinaryWriter(back);
        try
        {
            frontWriter.Write(byteIDCardPic1);
            backWriter.Write(byteIDCardPic2);
        }
        catch (Exception e)
        {
            Trace.WriteLine(e, "Exception");
        }
        finally
        {
            frontWriter.Flush();
            backWriter.Flush();
            front.Close();
            back.Close();
        }

        return "0";
    }

    [WebMethod]
    public string SubmitOrder(String KeyCode, String OrderInfo)
    {
        Trace.WriteLine(KeyCode, "SubmitOrder KeyCode");
        Trace.WriteLine(OrderInfo, "SubmitOrder OrderInfo");

        return "0";
    }

    [WebMethod]
    public string UpdatePayTaxStatus(String KeyCode, String WBID)
    {
        Trace.WriteLine(KeyCode, "Tax KeyCode");
        Trace.WriteLine(WBID, "Tax WBID");

        return "0";
    }

}
