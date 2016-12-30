package jmri.jmrit.decoderdefn;

import java.io.File;
import java.util.ArrayList;
import jmri.configurexml.SchemaTestBase;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Checks of JMRI XML Schema for decoder definition files.
 *
 * @author Bob Jacobsen Copyright 2010
 * @since 2.9.3
 */
@RunWith(Parameterized.class)
public class SchemaTest extends SchemaTestBase {

    @Parameters(name = "{0} (pass={1})")
    public static Iterable<Object[]> data() {
        ArrayList<Object[]> files = new ArrayList<>();
        // check that the schema passes useful constructs
        files.addAll(getFiles(new File("java/test/jmri/jmrit/decoderdefn/pass"), true, true));
        // check that the schema detects errors
        files.addAll(getFiles(new File("java/test/jmri/jmrit/decoderdefn/fail"), true, false));
        // check that XML files in xml/decoders and immediate subdirectories are
        // valid, but ignore further subdirectories
        File decoders = new File("xml/decoders/");
        files.addAll(getFiles(decoders, false, true));
        files.addAll(getDirectories(decoders, false, true));
        return files;
    }

    public SchemaTest(File file, boolean pass) {
        super(file, pass);
    }
}
