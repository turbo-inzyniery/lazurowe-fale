package pl.put.poznan.transformer.logic;


import java.util.ArrayList;

public class ReplicRemoval extends TransformerDecorator {
    public ReplicRemoval(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform() {
        String text = super.transform();
        String[] parts = text.split(" ");
        ArrayList<Integer> repliclist = new ArrayList<Integer>();
        ArrayList<String> purelist = new ArrayList<String>();

        for(int i = 0; i<=parts.length-2; i++){
                for (int j = i+1; j < parts.length; j++){
                    if(parts[i].equals(parts[j])){
                        repliclist.add(j);
                    }
                    else
                        break;
                }
        }

        for(int i = 0; i<=parts.length-1; i++){
            if(repliclist.contains(i)) continue;

            purelist.add(parts[i]);
        }

        String joined = String.join(" ", purelist);

        return joined;
    }
}
