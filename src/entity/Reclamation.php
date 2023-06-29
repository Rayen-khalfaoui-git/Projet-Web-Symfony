<?php



use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="FK_2", columns={"idCibleReclamation"}), @ORM\Index(name="FK_1", columns={"idReclamateur"})})
 * @ORM\Entity
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="idReclamation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idreclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="typeReclamation", type="string", length=20, nullable=false)
     */
    private $typereclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu", type="text", length=16777215, nullable=false)
     */
    private $contenu;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="datepro", type="date", nullable=false)
     */
    private $datepro;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idReclamateur", referencedColumnName="id")
     * })
     */
    private $idreclamateur;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idCibleReclamation", referencedColumnName="id")
     * })
     */
    private $idciblereclamation;


}
