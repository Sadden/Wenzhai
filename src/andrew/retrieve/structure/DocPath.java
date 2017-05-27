package andrew.retrieve.structure;

import java.util.Map;
import java.util.TreeMap;

public class DocPath {
	Map<String, Integer> path2idMap;
    String[] id2pathMap;

    public DocPath()
    {
        path2idMap = new TreeMap<String, Integer>();
        id2pathMap = new String[1024];
    }

    public Integer getId(String path)
    {
        return getId(path, false);
    }

    public String getPath(int id)
    {
        return id2pathMap[id];
    }

    public Integer getId(String path, boolean create)
    {
        Integer id = path2idMap.get(path);
        if (!create) return id;
        if (id == null)
        {
            id = path2idMap.size();
        }
        path2idMap.put(path, id);
        if (id2pathMap.length - 1 < id)
        {
            resize(path2idMap.size() * 2);
        }
        id2pathMap[id] = path;

        return id;
    }

    private void resize(int n)
    {
        String[] nArray = new String[n];
        System.arraycopy(id2pathMap, 0, nArray, 0, id2pathMap.length);
        id2pathMap = nArray;
    }

    private void loseWeight()
    {
        if (size() == id2pathMap.length) return;
        resize(path2idMap.size());
    }

    public int size()
    {
        return path2idMap.size();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < id2pathMap.length; i++)
        {
            if (id2pathMap[i] == null) break;
            sb.append(i).append("=").append(id2pathMap[i]).append("\n");
        }
        return sb.toString();
    }
}
