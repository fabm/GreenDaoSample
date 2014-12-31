package pt.ipg.mcm.generator.greendaosample.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.test.ApplicationTestCase;
import android.util.Log;
import de.greenrobot.dao.query.Query;
import junit.framework.Assert;
import pt.ipg.mcm.entities.DaoMaster;
import pt.ipg.mcm.entities.DaoSession;
import pt.ipg.mcm.entities.Teste;
import pt.ipg.mcm.entities.Teste2;
import pt.ipg.mcm.entities.Teste2Dao;
import pt.ipg.mcm.entities.TesteDao;

import java.util.List;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
  public ApplicationTest() {
    super(Application.class);
  }

  public void testDaos() {
    SQLiteDatabase db = new DaoMaster.DevOpenHelper(getContext(), "test", null).getWritableDatabase();
    DaoMaster daoMaster = new DaoMaster(db);

    DaoSession session = daoMaster.newSession();
    TesteDao testDao = session.getTesteDao();


    Teste teste = new Teste();
    teste.setNome("meu nome");

    testDao.insert(teste);


    db.close();

  }

}