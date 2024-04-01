# EXERCICE04
## 1- Les objets dont dépend la classe Jeu et qui sont forcément mockés dans un test pour automatiser jouer sont :

L'objet représentant le joueur (Joueur) : afin de simuler ses mises, débits et crédits.
L'objet représentant la banque (Banque) : pour vérifier si elle est solvable, créditer et débiter des sommes.

2- Scénarios (classes d’équivalence) pour tester jouer :
Le jeu est fermé.
Le joueur fait une mise valide et la somme des dés est différente de 7.
Le joueur fait une mise valide et la somme des dés est égale à 7.
Le joueur est insolvable.
La banque n'est pas solvable après un gain.

4 -Test le plus simple : le cas où le jeu est fermé.
Ce test est un test d'état car il vérifie simplement l'état du jeu (ouvert ou fermé).

5-ester le cas où le joueur est insolvable.
Pour tester que le jeu ne touche pas aux dés, nous pouvons utiliser des doublures (mocks) pour les dés et vérifier qu'ils ne sont pas utilisés lorsque le joueur est insolvable.
Ce test est un test d'interaction car il vérifie si le jeu interagit correctement avec les autres objets sans toucher aux dés lorsque le joueur est insolvable.

6- Continuer avec les autres scénarios.
Implémentation pour la banque et test impliquant la banque :
Cette implémentation utilise une classe concrète pour la banque, et le test vérifie si le jeu se ferme correctement lorsque la banque devient insolvable.
