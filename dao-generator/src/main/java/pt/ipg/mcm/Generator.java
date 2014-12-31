package pt.ipg.mcm;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

import java.io.IOException;

public class Generator {

  private void generate(String str0, String str1) throws Exception {
    String path = str0;
    String pac = str1;

    Schema schema = new Schema(3, pac);
    schema.enableKeepSectionsByDefault();
    schema.enableActiveEntitiesByDefault();

    Entity testEntity = schema.addEntity("Teste");
    testEntity.addIdProperty();
    testEntity.addStringProperty("nome");

    new DaoGenerator().generateAll(schema, path);
  }

  public static void main(String args[]) throws Exception {
    Generator generator = new Generator();
    generator.generate(args[0],args[1]);
  }


}
