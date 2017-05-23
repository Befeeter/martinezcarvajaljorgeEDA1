package org.eda1.practica01.ejercicio01;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Editor {
	public final static char COMMAND_START = '$';
    public final static char DELIMITER = '%';

    public final static String INSERT_COMMAND = "$Insert";

    public final static String DELETE_COMMAND = "$Delete";

    public final static String LINE_COMMAND = "$Line";

    public final static String DONE_COMMAND = "$Done";
    
    public final static String LAST_COMMAND = "$Last";

    public final static String GETLINES_COMMAND = "$GetLines";
    
    public final static String CHANGE_COMMAND = "$Change";
    
    public final static String BAD_LINE_MESSAGE =
       "Error: a command should start with " + COMMAND_START + ".\n";

    public final static String BAD_COMMAND_MESSAGE =
       "Error: not one of the given commands.\n";

    public final static String INTEGER_NEEDED =
       "Error: The command should be followed by a blank space, " +
       "\nfollowed by an integer.\n";

    public final static String TWO_INTEGERS_NEEDED =
       "Error: The command should be followed by a blank space, " +
       "\nfollowed by an integer, followed by a blank space, " +
       "followed by an integer.\n";

    public final static String FIRST_GREATER =
       "Error: the first line number is greater than the second.\n";

    public final static String FIRST_LESS_THAN_ZERO =
       "Error: the first line number given is less than 0.\n";

    public final static String SECOND_TOO_LARGE =
       "Error: the second line number given is greater than the " +
       "\nnumber of the last line in the text.\n";

    public final static String M_LESS_THAN_ZERO =
       "Error: the number is less than 0.\n";

    public final static String M_TOO_LARGE =
       "Error: the number is larger than the number of lines in the text.\n";

    public final static String LINE_TOO_LONG =
       "Error: the line exceeds the maximum number of characters allowed, ";

    public final static String INCORRECT_DELIMITERS_NUMBER =
       "Error: Delimiter must occur three times. Please try again.\n";
    
    public final static String NO_DELIMITERS_BEGIN_END =
       "Error: Bad Expression format, delimiters should be at the beginning " + 
       "\nand at the end. Please try again.\n";

    public final static String TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING =
       "Error: Bad Expression format, two consecutive delimiters " +
       "\nat the beginning. Please try again.\n";

    public final static int MAX_LINE_LENGTH = 80;

	protected LinkedList<String> text;
	protected ListIterator<String> current;
	protected boolean inserting;

	public Editor() {
		text = new LinkedList<String>();
		current = text.listIterator(); // devuelve un iterator apuntando delante
										// de la posicion 0
		inserting = false;

	}

	public String interpret(String s) {
		if (s.equals(""))
			throw new RuntimeException(BAD_LINE_MESSAGE);
		/*
		 * if (s.charAt(0) != '$') if (inserting == true) insert(s); else throw
		 * new RuntimeException(BAD_LINE_MESSAGE);
		 */
		
		StringTokenizer sToken = new StringTokenizer(s, " ");
		String palabra = sToken.nextToken();

		if (!palabra.equals(INSERT_COMMAND) && !palabra.equals(DELETE_COMMAND)
				&& !palabra.equals(LINE_COMMAND)
				&& !palabra.equals(DONE_COMMAND)
				&& !palabra.equals(LAST_COMMAND)
				&& !palabra.equals(GETLINES_COMMAND)
				&& !palabra.equals(CHANGE_COMMAND))
			if (inserting == true){
				insert(s);
				return null;
			}
			else{
				if (palabra.equals(INSERT_COMMAND.substring(1)) || 
						palabra.equals(DELETE_COMMAND.substring(1)) ||
						palabra.equals(LINE_COMMAND.substring(1)) ||
						palabra.equals(DONE_COMMAND.substring(1)) ||
						palabra.equals(LAST_COMMAND.substring(1)) ||
						palabra.equals(GETLINES_COMMAND.substring(1)) ||
						palabra.equals(CHANGE_COMMAND.substring(1)))
					throw new RuntimeException (BAD_LINE_MESSAGE);
				else
					throw new RuntimeException(BAD_COMMAND_MESSAGE);
			}
		if (palabra.equals(INSERT_COMMAND)) {
			inserting = true;
			return null;
		}
		if (palabra.equals(DELETE_COMMAND)) {
			inserting = false;
			if (!sToken.hasMoreTokens())
				throw new RuntimeException(TWO_INTEGERS_NEEDED);
			String sNum1, sNum2;
			sNum1 = sToken.nextToken();
			if (!sToken.hasMoreTokens())
				throw new RuntimeException(TWO_INTEGERS_NEEDED);
			sNum2 = sToken.nextToken();
			int num1, num2;
			try {
				num1 = Integer.parseInt(sNum1);
				num2 = Integer.parseInt(sNum2);
			} catch (RuntimeException e) {
				throw new RuntimeException(TWO_INTEGERS_NEEDED);

			}
			delete(num1, num2);
			return null;
		}

		if (palabra.equals(LINE_COMMAND)) {
			inserting = false;
			if (!sToken.hasMoreTokens())
				throw new RuntimeException(INTEGER_NEEDED);
			String sNum1;
			sNum1 = sToken.nextToken();
			int num1;
			try {
				num1 = Integer.parseInt(sNum1);
			} catch (RuntimeException e) {
				throw new RuntimeException(INTEGER_NEEDED);
			}
			setCurrentLineNumber(num1);

		}
		if (palabra.equals(DONE_COMMAND)) {
			inserting = false;
			return done();
		}
		if (palabra.equals(LAST_COMMAND)) {
			inserting = false;
			return last();
		}
		if (palabra.equals(GETLINES_COMMAND)) {
			inserting = false;
			if (!sToken.hasMoreTokens())
				throw new RuntimeException(TWO_INTEGERS_NEEDED);
			String sNum1, sNum2;
			sNum1 = sToken.nextToken();
			if (!sToken.hasMoreTokens())
				throw new RuntimeException(TWO_INTEGERS_NEEDED);
			sNum2 = sToken.nextToken();
			int num1, num2;
			try {
				num1 = Integer.parseInt(sNum1);
				num2 = Integer.parseInt(sNum2);
			} catch (RuntimeException e) {
				throw new RuntimeException(TWO_INTEGERS_NEEDED);
			}
			return getLines(num1, num2);
		}
		if (palabra.equals(CHANGE_COMMAND)) {
			inserting = false;
			if (!sToken.hasMoreTokens())
				throw new RuntimeException(NO_DELIMITERS_BEGIN_END);
			String cad = sToken.nextToken();
			while (sToken.hasMoreTokens()) {
				cad = cad + " " + sToken.nextToken();
			}
			change(cad);
		}

		return null;

	}

	protected void tryToDelete(Scanner sc) {

	}

	protected void tryToSetCurrentLineNumber(Scanner sc) {

	}

	protected void insert(String s) {
		if (s.length() > MAX_LINE_LENGTH)
			throw new RuntimeException(LINE_TOO_LONG);
		if (inserting == true) {
			/*
			 * if (current != null) { text.add(current.nextIndex() + 1, s);
			 * setCurrentLineNumber(current.nextIndex() + 1); } else {
			 * text.add(s); setCurrentLineNumber(text.size() - 1); }
			 */
			current.add(s);
		}

	}

	protected void delete(int m, int n) {
		if (m < 0)
			throw new RuntimeException(FIRST_LESS_THAN_ZERO);
		if (m > n)
			throw new RuntimeException(FIRST_GREATER);
		if (n >= text.size())
			throw new RuntimeException(SECOND_TOO_LARGE);
		for (int i = m; i <= n; i++)
			text.remove(m);
		/*
		 * current = text.listIterator(); for (int i = 0; i < m; i++)
		 * current.next();
		 */
		setCurrentLineNumber(m);

	}

	protected void setCurrentLineNumber(int m) {
		if (m < 0)
			throw new RuntimeException(M_LESS_THAN_ZERO);
		if (m > text.size())
			throw new RuntimeException(M_TOO_LARGE);
		current = text.listIterator();
		for (int i = 0; i < m; i++)
			current.next();

	}

	protected String done() {
		String cadena = "";

		for (int i = 0; i < text.size(); i++) {
			if (i == current.nextIndex())
				cadena = cadena + ">  " + text.get(i) + "\n";
			else
				cadena = cadena + "   " + text.get(i) + "\n";
		}
		if (current.nextIndex() >= text.size())
			cadena = cadena + ">  \n";
		return cadena;
	}

	protected String last() {
		String cadena = Integer.toString(text.size() - 1);
		return cadena;
	}

	protected String tryToGetLines(Scanner sc) {
		return null;
	}

	protected String getLines(int m, int n) {
		String cadena = "";
		if (m > n)
			throw new RuntimeException(FIRST_GREATER);
		if (m < 0)
			throw new RuntimeException(M_LESS_THAN_ZERO);
		if (n >= text.size())
			throw new RuntimeException(SECOND_TOO_LARGE);
		// Devolver numero de linea y contenido de la liena.
		for (int i = m; i <= n; i++) {
			cadena = cadena + i + "\t" + text.get(i);
			if (i < n)
				cadena = cadena + "\n";
		}
		return cadena;
	}

	protected void tryToChange(Scanner sc) {

	}

	protected void change(String parameter) {
		String cadena1 = "", cadena2 = "", cadena3 = "";

		// en primer lugar cuento el numero de %
		int cont = 0;
		for (int i = 0; i < parameter.length(); i++) {
			if (parameter.charAt(i) == '%')
				cont++;
		}
		if (cont != 3)
			throw new RuntimeException(INCORRECT_DELIMITERS_NUMBER);
		// dos %% al principio
		Pattern exp2 = Pattern.compile("%%.*%");
		Matcher mat2 = exp2.matcher(parameter);
		if (mat2.matches())
			throw new RuntimeException(TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING);

		// no acaba o empieza por %
		if (parameter.charAt(0) != '%'
				|| parameter.charAt(parameter.length() - 1) != '%')
			throw new RuntimeException(NO_DELIMITERS_BEGIN_END);

		// cojo primer trozo
		cadena1 = "";
		int n = 1;
		while (parameter.charAt(n) != '%') {
			cadena1 = cadena1 + parameter.charAt(n);
			n++;
		}
		n++;
		cadena2 = "";
		while (parameter.charAt(n) != '%') {
			cadena2 = cadena2 + parameter.charAt(n);
			n++;
		}
		//for (int i = 0; i < text.size(); i++) {
			cadena3 = text.get(current.nextIndex());
			//setCurrentLineNumber(i); añade la posibilidad de cambiar varias
			// entradas del array.
			if (cadena3.indexOf(cadena1) != -1) {
				cadena3 = cadena3.replace(cadena1, cadena2);
				text.set(current.nextIndex(), cadena3);
			//}
		}
	}

}