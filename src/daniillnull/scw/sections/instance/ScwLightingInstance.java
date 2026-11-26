package daniillnull.scw.sections.instance;

import daniillnull.collada.instance.ColladaInstance;
import daniillnull.scw.util.ScwInputStream;
import daniillnull.scw.util.ScwOutputStream;

import java.io.IOException;

public class ScwLightingInstance extends ScwInstance<ColladaInstance> {
    public String lightingName;

    @Override
    public void load(ScwInputStream is) throws IOException {
        lightingName = is.readUTF();
    }

    @Override
    public void save(ScwOutputStream os) throws IOException {
        os.writeUTF(lightingName);
    }

    @Override
    public String getSectionName() {
        return "LIGH";
    }

    @Override
    public ColladaInstance asCollada() {
        return null;
    }
}