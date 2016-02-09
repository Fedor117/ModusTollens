package model;

import java.util.ArrayList;

public class StatementNode {

    String statement;
    ArrayList<StatementNode> connections;

    public StatementNode(String statement) {
        this.statement   = statement;
        this.connections = null;
    }

    public void addConnection(StatementNode connected) {
        connections.add(connected);
    }

}
