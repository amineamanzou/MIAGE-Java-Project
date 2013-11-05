## AMANZOU Amine / BLOT  Eva 
9/20
```
Interface Dico : OK
rechercher : KO
supprimer : OK--
obtenirCles : KO
necessiteReorg : OK-
reorganiser : KO
```

## Remarques
### ABR : 
on  avait dit que les fg  et  fd  existaient  toujours donc le  constructeur  de  Nœud  faisait un 
```bash
fg   =   new   ABR<>()  et   fd  =   new   ABR<>()
```
    L’idée était que fg et fd existent toujours (donc jamais null) et que du coup on peut toujours 
    appeler les méthodes de fg/d. Par exemple fg.isEmpty(). Cela permettait d’éviter d’avoir les tests 
    comme racine.fg != null. Dou coup vous les avez oubliés dans get() ou remove() (vous aurez des NullPointer). 
    Ceci est à reprendre. Les size++ dans put() ne marchent pas si la clé existe déjà ! Ici, le plus simple est de 
    ne pas maintenir le nombre d’éléments mais de le recalculer à la demande .
    
### Put : 
on avait dit que ça renvoyait null si la clé était nouvellement créée.

### Autre :
    remove()  est couteux (fait 2 parcours) 
    getMax() ne doit pas être public (sinon doit être dans l’interface). Vous auriez dû faire un removeMax() pour 
    eviter les 2 parcours
    toString : Bien
