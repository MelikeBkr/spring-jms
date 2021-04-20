package mel.springjms.model;

import java.io.Serializable;
import java.util.UUID;

public class HelloWorldMessage implements Serializable
{
    static final long serialVersionUID = 8768352242875117769L;
    private UUID id;
    private String message;
}
