package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qvar_objTrad extends Qvar_obj {
    public Qvar_objTrad(String name) { super(name); }
    
    private ChunkedQueue q = new ChunkedQueue();
    
    public void add(VarNode _var, AllocNode _obj) {
        q.add(_var);
        q.add(_obj);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { obj.v(), var.v() },
                                              new PhysicalDomain[] { H1.v(), V1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-t" +
                                               "runk2/src/soot/jimple/paddle/queue/Qvar_objTrad.jedd:38,22-2" +
                                               "4"),
                                              in).iterator(new Attribute[] { var.v(), obj.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 2; i++) { this.add((VarNode) tuple[0], (AllocNode) tuple[1]); }
        }
    }
    
    public Rvar_obj reader(String rname) { return new Rvar_objTrad(q.reader(), name + ":" + rname); }
}
