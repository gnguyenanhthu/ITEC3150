package itec;

import edu.ggc.itec.Queen;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenTest {

    @Test
    void getBirthYear() {
        Queen q = new Queen("Mary I", 1516, 1552, 1558);
        assertEquals(1516, q.getBirthYear());
    }

    @Test
    void getBeginReignYear() {
        Queen q = new Queen("Mary I", 1516, 1552, 1558);
        assertEquals(1552, q.getBeginReignYear());
    }

    @Test
    void getEndReignYear() {
        Queen q = new Queen("Mary I", 1516, 1552, 1558);
        assertEquals(1558, q.getEndReignYear());
    }

    @Test
    void getName() {
        Queen q = new Queen("Mary I", 1516, 1552, 1558);
        assertEquals("Mary I", q.getName());
    }

    @Test
    void getReign() {
        Queen q = new Queen("Mary I", 1516, 1552, 1558);
        assertEquals(1558-1552, q.getReign());
    }

    @Test
    public void testRead() throws IOException {

        Queen expected = null;

        File scratch = new File("queens-for-testing-only.dat");
        DataInputStream dis = new DataInputStream(new FileInputStream(scratch));
        Queen q3 = new Queen(dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt());
        expected = new Queen("Queen III", 1600, 1601, 1699);
        assertEquals(expected, q3);

        Queen q4 = new Queen(dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt());
        expected = new Queen("Queen IV", 1700, 1701, 1799);
        assertEquals(expected, q4);

    }

    @Test
    public void testWriteRead() throws IOException {

        Queen q1 = new Queen("Mary I", 1516, 1552, 1558);
        Queen q2 = new Queen("Victoria", 1819, 1837, 1901);

        File scratch = new File("queens-sample.dat");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(scratch));
        dos.writeUTF(q1.getName());
        dos.writeInt(q1.getBirthYear());
        dos.writeInt(q1.getBeginReignYear());
        dos.writeInt(q1.getEndReignYear());
        dos.writeUTF(q2.getName());
        dos.writeInt(q2.getBirthYear());
        dos.writeInt(q2.getBeginReignYear());
        dos.writeInt(q2.getEndReignYear());
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream(scratch));
        Queen q3 = new Queen(dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt());
        assertEquals(q1, q3);
        Queen q4 = new Queen(dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt());
        assertEquals(q2, q4);

        scratch.delete();
    }

}