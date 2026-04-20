package co.edu.unbosque.miprimerspring.dto;

import java.util.List;

public class MultipleJokeDTO {

	private List<JokeDTO> jokes;

	public MultipleJokeDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<JokeDTO> getJokes() {
		return jokes;
	}

	public void setJokes(List<JokeDTO> jokes) {
		this.jokes = jokes;
	}

	@Override
	public String toString() {
		return "MultipleJokeDTO [jokes=" + jokes + "]";
	}

}
