import java.util.Random;
public class RPGcharecter {
    String name;
    int level;
    int maxHP;
    int currentHP;
    int maxMana;
    int currentMana;
    int runSpeed;
    int attack;
    int defense;
    int intelligence ;
    int atkBonus;
    int intBonus;
    int defBonus;
    Equipment equippedSword;
    Equipment equippedShield;
    Accessory equippedRing;
    Accessory equippedNecklace;


    public RPGcharecter(String name, int level, int maxHP, int maxMana, int runSpeed, int attack, int defense,int intelligence) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMana = maxMana;
        this.currentMana = maxMana;
        this.runSpeed = runSpeed;
        this.attack = attack;
        this.defense = defense;
        this.intelligence = intelligence ;
    }


    public static class WizardCharacter extends RPGcharecter {
        public WizardCharacter(String name, int level) {
            super(name, level, 50, 120, 7, 3, 5, 12);
        }

        public void levelUp() {
//        preconditions
//          ต้องมีการสร้างตัวของ WizardCharacter ก่อน
//        postconditions
//         เลเวลของตัวละครจะเพิ่มขึ้น 1 เลเวล
//         stats ต่างๆจะถูกบวกเพิ่ม
//        side effects
//          เลเวลตัวละครเพิ่ม
//          ค่า stats เปลี่ยน
            super.levelUp();
            maxHP += 15 ;
            currentHP = maxHP;
            maxMana += 10;
            currentMana = maxMana;
            runSpeed += 1;
            attack += 1 ;
            intelligence += 1 ;
            defense += 2 ;
            updateRunSpeed();
        }
    }
    public static class MonkCharacter extends RPGcharecter {
        public MonkCharacter(String name, int level) {
            super(name, level, 80, 150, 10, 5, 8, 5);
        }

        public void levelUp() {
//        preconditions
//          ต้องมีการสร้างตัวของ MonkCharacter ก่อน
//        postconditions
//         เลเวลของตัวละครจะเพิ่มขึ้น 1 เลเวล
//         stats ต่างๆจะถูกบวกเพิ่ม
//        side effects
//          เลเวลตัวละครเพิ่ม
//          ค่า stats เปลี่ยน
            super.levelUp();
            maxHP += 5;
            currentHP = maxHP;
            maxMana += 10;
            currentMana = maxMana;
            runSpeed += 1;
            attack += 1;
            intelligence += 2;
            defense += 1;
            updateRunSpeed();
        }
    }
    public void levelUp(){
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter ก่อน
//        postconditions
//         เลเวลของตัวละครจะเพิ่มขึ้น 1 เลเวล
//        side effects
//          เลเวลตัวละครเพิ่ม
//          พิมแสดงให้เห็นว่าเลเวลอัพ
        level++ ;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public void  EquipRing(Ring ring){
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter และ ring ก่อน
//        postconditions
//         ตัวละครจะมีการสวมใส่แหวน
//         ค่าจะสุ่มและเอามาใช้ตามแคสต่างๆ
//        side effects
//          ตัวละครสวมใส่แหวน
//          ค่าจะสุ่มเพิ่มขึ้นมามี int atk def ที่จะเพิ่ม
        equippedRing = ring ;
        Random random = new Random();
        int bonusType = random.nextInt(3);
        switch (bonusType) {
            case 0:
                atkBonus = random.nextInt(11); // Random value between 0 and 10
                break;
            case 1:
                intBonus = random.nextInt(11);
                break;
            case 2:
                defBonus = random.nextInt(11);
                break;
        }
        System.out.println(name + " have a ring equipped. ");
        if (atkBonus != 0) {
            attack += atkBonus ;
            System.out.println("!! Have attack Bonus: " + atkBonus);
        } else if (intBonus != 0) {
            intelligence += intBonus ;
            System.out.println("!! Have intelligence Bonus: " + intBonus);
        } else if (defBonus != 0) {
            defense += defBonus ;
            System.out.println("!! Have defense Bonus: " + defBonus);
        }
    }
    public void EquipNecklace(Necklace necklace){
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter และ necklace ก่อน
//        postconditions
//         ตัวละครจะมีการสวมใส่สร้อย
//         ค่า MaxHP จะเพิ่มขึ้น
//        side effects
//          ตัวละครสวมใส่โล่
//          ค่า MaxHP เพิ่ม
        equippedNecklace = necklace ;
        maxHP += necklace.HPplus ;
        System.out.println((name + " have a necklace equipped. "));
    }

    public void EquipSword(Sword sword) {
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter และ sword ก่อน
//        postconditions
//         ตัวละครจะมีการสวมใส่ดาบ
//         ค่า atk จะเพิ่มขึ้น
//        side effects
//          ตัวละครสวมใส่โล่
//          ค่า atk เพิ่ม
//          ความเร็วลดลง
        equippedSword = sword;
        attack += sword.damage;
        updateRunSpeed();
        System.out.println(name + " have a sword equipped.");
    }

    public void EquipShield(Shield shield) {
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter และ shield ก่อน
//        postconditions
//         ตัวละครจะมีการสวมใส่โล่
//         ค่า def จะเพิ่มขึ้น
//        side effects
//          ตัวละครสวมใส่โล่
//          ค่า def เพิ่ม
//          ความเร็วลดลง
        equippedShield = shield;
        defense += shield.reducedamage;
        updateRunSpeed();
        System.out.println(name + " have a shield equipped.");
    }

    public void LevelupSword() {
//        preconditions
//          ต้องมีการสร้างตัวของ Sword ก่อน
//          และต้องสวมใส่ Sword
//        postconditions
//         เลเวลของดาบเพิ่ม 1 เลเวล
//         โดย stats ของ ดาบจะเพิ่มตาม LevelUP ใน class Equipment ที่เป็นของ sword
//        side effects
//          เลเวลดาบเพิ่ม
//          ค่า stats ของดาบเปลี่ยน
//          พิมแสดงให้เห็นว่าเลเวลอัพ
        if (equippedSword != null) {
            equippedSword.Levelup() ;
            attack += equippedSword.getLevel();
            System.out.println(name + "'s sword has leveled up to level " + equippedSword.getLevel() + "!");
            updateRunSpeed();
        } else {
            System.out.println(name + " does not have a sword equipped.");
        }
    }

    public void LevelUpShield() {
//        preconditions
//          ต้องมีการสร้างตัวของ Shield ก่อน
//          และต้องสวมใส่ Shield
//        postconditions
//         เลเวลของโล่เพิ่ม 1 เลเวล
//         โดย stats ของ โล่จะเพิ่มตาม LevelUP ใน class Equipment ที่เป็นของ Shield
//        side effects
//          เลเวลโล่เพิ่ม
//          ค่า stats ของโล่เปลี่ยน
//          พิมแสดงให้เห็นว่าเลเวลอัพ
        if (equippedShield != null) {
            equippedShield.Levelup();
            defense += equippedShield.getLevel();
            System.out.println(name + "'s shield has leveled up to level " + equippedShield.getLevel() + "!");
            updateRunSpeed();
        } else {
            System.out.println(name + " does not have a shield equipped.");
        }
    }
    public void LevelUpNecklace() {
//        preconditions
//          ต้องมีการสร้างตัวของ Necklace ก่อน
//          และต้องสวมใส่ Necklace
//        postconditions
//         เลเวลของสร้อยเพิ่ม 1 เลเวล
//         โดย stats ของ สร้องจะเพิ่มตาม LevelUP ใน class Accessory ที่เป็นของ Necklace
//        side effects
//          เลเวลโล่เพิ่ม
//          ค่า stats ของสร้อยเปลี่ยน
//          พิมแสดงให้เห็นว่าเลเวลอัพ
        if (equippedNecklace != null) {
            equippedNecklace.Levelup();
            maxHP += equippedNecklace.getLevel();
            System.out.println(name + "'s necklace has leveled up to level " + equippedNecklace.getLevel() + "!");
            updateRunSpeed();
        } else {
            System.out.println(name + " does not have a necklace equipped.");
        }
    }

    public void ActionAttack(RPGcharecter target) {
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter โจมตี
//          ต้องมีการสร้างตัวของ RPGcharecter ถูก**โจมตี
//        postconditions
//          ตัวละครที่จะโจมตีต้องติดตั้งอาวุธก่อน จึงจะโจมตีได้ เราคงไม่ต่อยมอนตเอร์ด้วยหมัดเปล่าหรอกเนอะ
//        side effects
//          ตัวละครที่ถูกโจทตี currentHP จะลดตาม damage ที่ได้รับจากผู้โจมตี
//          พิมบอกข้อความว่าได้รับความเสียหายจากใครและด้วยอะไร
        if (equippedSword != null) {
            System.out.println(name + " is attacking " + target.getName() + " with " + equippedSword.getName() + "!");
            int damage = calculateDamage();
            target.takeDamage(damage);
        } else {
            System.out.println(name + " does not have a sword equipped. Cannot attack.");
        }
    }

    private int calculateDamage() {
        int baseDamage = attack;
        if (equippedSword != null) {
            baseDamage += equippedSword.getLevel(); // Consider the sword's level for additional damage
        }
        return baseDamage;
    }

    public void takeDamage(int damage) {
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter มาก่อน
//          damage ที่คำนวณต้องไม่ติดลบ
//        postconditions
//          ค่า currentHP จะมีการปรับลดตาม damage ที่ได้รับ
//        side effects
//          ค่า currentHP จะมีการเปลี่ยนแปลง
        int effectiveDefense = defense;
        if (equippedShield != null) {
            effectiveDefense += equippedShield.getLevel(); // Consider the shield's level for additional defense
        }

        int actualDamage = Math.max(0, damage - effectiveDefense);
        currentHP -= actualDamage;

        if (currentHP < 0) {
            currentHP = 0;
        }
        System.out.println(name + " took " + actualDamage + " damage. Current HP: " + currentHP);
    }

    public void updateRunSpeed() {
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter มาก่อน
//        postconditions
//          ความเร็วของตัวละครจะเพิ่มหรือลดตามการติดตั้งอาวุธและโล่ที่ส่วมใส่
//        side effects
//          ความเร็วของตัวละครเปลี่ยนไป
        int swordRunSpeedEffect = (equippedSword != null) ? equippedSword.getRunSpeedEffect() : 0;
        int shieldRunSpeedEffect = (equippedShield != null) ? equippedShield.getRunSpeedEffect() : 0;
        runSpeed = Math.max(0, 10 - swordRunSpeedEffect - shieldRunSpeedEffect );
    }

    public String getName(){
        return  name ;
    }

    public void showStats() {
//        preconditions
//          ต้องมีการสร้างตัวของ RPGcharecter มาก่อน
//        postconditions
//          แสดงค่า stats ต่างๆ
//        side effects
//          พิมแสดงค่า stats ออกมา
        System.out.println("Character Stats for " + name + ":");
        System.out.println("Level: " + level);
        System.out.println("HP: " + currentHP + "/" + maxHP);
        System.out.println("Mana: " + currentMana + "/" + maxMana);
        System.out.println("Attack: " + attack);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Defense: " + defense);
        System.out.println("Run Speed: " + runSpeed);
        System.out.println("Equipped Sword: " + ((equippedSword != null) ? equippedSword.getName() : "None"));
        System.out.println("Equipped Shield: " + ((equippedShield != null) ? equippedShield.getName() : "None"));
        System.out.println("-----------------------------");
    }