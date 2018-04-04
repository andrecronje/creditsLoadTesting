import com.credits.common.utils.Converter;
import com.credits.wallet.desktop.App;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.utils.ApiUtils;
import com.credits.wallet.desktop.utils.Utils;
import com.credits.leveldb.client.ApiClient;
import com.credits.wallet.desktop.utils.Utils;
import java.io.FileInputStream;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import com.credits.crypto.Ed25519;
import com.credits.wallet.desktop.App;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class loadTest
{

  public static void main(String args[]) {
	  try {
      Locale loc = Locale.getDefault();
      DecimalFormatSymbols symbols = new DecimalFormatSymbols(loc);
      char sep = symbols.getDecimalSeparator();
      AppState.decSep = Character.toString(sep);

      FileInputStream fis = new FileInputStream("settings.properties");
      Properties property = new Properties();
      property.load(fis);

      AppState.creditMonitorURL = property.getProperty("creditmonitor.url");

      String apiAddr = property.getProperty("api.addr");
      String apiPort = property.getProperty("api.port");
      AppState.contractExecutorHost = property.getProperty("contract.executor.host");
      try {
        AppState.contractExecutorPort = Integer.valueOf(property.getProperty("contract.executor.port"));
      }
      catch (Exception localException1) {System.out.print('1');}


      if ((apiAddr == null) || (apiAddr.isEmpty()) || (apiPort == null) || (apiPort.isEmpty())) {
      } else if ((AppState.contractExecutorHost == null) || (AppState.contractExecutorPort == null))
      {
		  System.out.print('2');
      } else {
        AppState.apiClient = ApiClient.getInstance(apiAddr, Integer.valueOf(apiPort));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
	    try {
		      AppState.account = "accXpfvxnZa8txuxpjyPqzBaqYPHqYu2rwn34lL8rjI=";
      } catch (Exception e) {
        e.printStackTrace();
      }
	    try {
  		  for (int i = 0; i < 1000; i++) {
  			  new Thread("" + i){
            public void run(){
              for (int i = 0; i < 1000; i++) {
        			  new Thread("" + i){
                  public void run(){
              			try {
              				for (int x = 0; x < 1000000; x++) {
              					ApiUtils.prepareAndCallTransactionFlowSystem(AppState.account);
              				}
              			} catch (Exception e) {
              				 e.printStackTrace();
              			}
                  }
                }.start();
      		    }
            }
          }.start();
		    }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
  }
}
