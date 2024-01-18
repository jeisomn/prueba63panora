import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environments } from '../page/envoronments/environments';
import { Persona } from '../page/modelo/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  constructor(private http: HttpClient) { }

  getClientes(){
    let url = environments.WS_PATH + "/persona/list"
    return this.http.get<any>(url)
  }

  saveCliente(persona: Persona){
    let url = environments.WS_PATH + "/persona"
    return this.http.post<any>(url, persona)
  }

  deleteCliente(codigo: number) {
    let url = environments.WS_PATH + '/persona?id=' + codigo;
    console.log(url);
    return this.http.delete<any>(url)
  }

  actualizarCliente(persona: Persona){
    let url = environments.WS_PATH + "/persona"; // Ajusta la URL según tu API
    return this.http.put<any>(url, persona);
  }
}
