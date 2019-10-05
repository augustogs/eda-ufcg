import java.util.Arrays;
import java.util.Scanner;

class HTProbingLinear {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		Tabelahash tabela = new Tabelahash(tamanho);
		String[] entrada;
		String option;
		do {
			entrada = sc.nextLine().split(" ");
			option = entrada[0];
			if ("put".equals(option)) {
				Integer chave = Integer.parseInt(entrada[1]);
				String valor = entrada[2];
				System.out.println(tabela.put(chave, valor));
			}
			
			if ("remove".equals(option)) {
				Integer chave = Integer.parseInt(entrada[1]);
				System.out.println(tabela.remove(chave));
			}
			
			if ("keys".equals(option)) {
				System.out.println(Arrays.toString(tabela.keys()));
			}
			
			if ("values".equals(option)) {
				System.out.println(Arrays.toString(tabela.values()));
			}
			
		} while (!option.equals("end"));
		
		sc.close();
	}	
	
}

class Tabelahash {
	
	private Pair[] table;
	private int elements;
	
	public Tabelahash(int tamanho) {
		this.table = new Pair[tamanho];
		this.elements = 0;
	}
		
	public String put(int key, String value) {
		if (!this.isFull()) {
			int i = 0;
			boolean inseriu = false;
			
			while (i < this.table.length && !inseriu) {
				int j = this.hashFunction(key + i);
				
				if (this.table[j] == null || this.table[j].wasRemoved()) {
					this.table[j] = new Pair(key, value);
					this.elements++;
					inseriu = true;
				}
				else if (this.table[i].getKey() == key) {
					this.table[j].setValue(value);
					inseriu = true;
				}
				i++;	
			}
		}
		return this.toString();
	}
	
	public String remove(int key) {
		if (!this.isEmpty()) {
			int i = 0;
			boolean removeu = false;
			
			while (i < this.table.length && !removeu) {
				int j = this.hashFunction(key + i);
				if (this.table[j] != null && this.table[j].getKey() == key) {
					this.table[j].remove();
					this.elements--;
					removeu = true;
				}
				i++;
			}	
		}
		return this.toString();
	}
	
	public Integer[] keys() {
		Integer[] keys = new Integer[this.elements];
		int j = 0;
		int i = 0;
		while (i < this.table.length) {
			if (this.table[i] != null && !this.table[i].wasRemoved()) {
				keys[j] = this.table[i].getKey();
				j++;
			}
			i++;
		}
		Arrays.sort(keys);
		return keys;		
	}
	
	public String[] values() {
		String[] values = new String[this.elements];
		int j = 0;
		int i = 0;
		while (i < this.table.length) {
			if (this.table[i] != null && !this.table[i].wasRemoved()) {
				values[j] = this.table[i].getValue();
				j++;
			}
			i++;
		}
		Arrays.sort(values);
		return values;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.table);
	}
	
	private int hashFunction(Integer key) {
		return key % this.table.length;
	}
	
	private boolean isEmpty() {
		return (this.elements == 0);
	}
	
	private boolean isFull() {
		return (this.table.length == this.elements);
	}
	
}

class Pair {
	
	private Integer key;
	private String value;
	private boolean removed;

	public Pair(Integer chave, String value) {
		this.key = chave;
		this.value = value;
		this.removed = false;
	}
	
	public void remove() {
		this.removed = true;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getKey() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public boolean wasRemoved() {
		return this.removed;
	}
	
	public String toString() {
		String result = null;
		if (!removed) {
			result = "<" + this.key + ", " + this.value + ">";
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}

