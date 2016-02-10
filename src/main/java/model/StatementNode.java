package model;

import java.util.ArrayList;
import java.util.List;

public class StatementNode {

    String statement;
    List<StatementNode> connections;

    public StatementNode(String statement) {
        this.statement   = statement;
        this.connections = new ArrayList<>();
    }

    public void addConnection(StatementNode connected) {
        connections.add(connected);
    }

}
