import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Fight
{	
	static int[] Status = {0,0,0,0,0,0,0,0};
	static String MonsterName = "";

	public static void DotLine()
	{
		System.out.print("\n\n\n----------------------------------------------------------\n\n\n");
	}


	Fight(){}

	Fight(int a, int b, int c, int d, int e, int f, int g, int h, String Name)
	{
		Status[0] = a; // 체력
		Status[1] = b; // 공격
		Status[2] = c; // 방어
		Status[3] = d; // 행운
		Status[4] = e; // 경험
		Status[5] = f; // 최대체력
		Status[6] = g; // 골드
		Status[7] = h; // 레벨
		MonsterName = Name;
		
	}

	public static int[][][] MetMonster(int [][][] User) throws InterruptedException, IOException
	{
		Random rd = new Random();
		
		int value = rd.nextInt(44) + 1;

		if (value == 1)
		{
			Fight a1 = new Fight(2, 3, 2, 1,10,0,20,1, "꿀같은 점심시간");
			System.arraycopy(a1.Battle(User),0,User,0,User.length);			

		}
		if (value == 2)
		{
			Fight a2 = new Fight(3, 5, 3, 1,10,0,20,1, "휴강");
			System.arraycopy(a2.Battle(User),0,User,0,User.length);			

		}
		if (value == 3)
		{
			Fight a3 = new Fight(5, 7, 2, 1,10,0,20,1, "학교 축제");
			System.arraycopy(a3.Battle(User),0,User,0,User.length);			

		}
		

		if (value == 4)
		{
			Fight a4 = new Fight(5, 7, 2, 1,6,0,10,1, "일청담 비둘기");
			System.arraycopy(a4.Battle(User),0,User,0,User.length);			

		}

		if (value == 5)
		{
			Fight a5 = new Fight(6,7 , 3, 1,8,0,10,1, "스쿨 버스 기사님");
			System.arraycopy(a5.Battle(User),0,User,0,User.length);		



		}
		if (value == 6 )
		{
			Fight a6 = new Fight(6, 8, 3, 2,7,0,10,1, "복사집 아저씨");
			System.arraycopy(a6.Battle(User),0,User,0,User.length);		


		}
		if (value == 7)
		{
			Fight a7 = new Fight(7, 8, 3, 2,7,0,15,1, "경대리아 알바생");
			System.arraycopy(a7.Battle(User),0,User,0,User.length);		


		}
		if (value == 8)
		{
			Fight a8 = new Fight(8, 9, 3, 2,7,0,15,1, "길을 물어보는 외부인");
			System.arraycopy(a8.Battle(User),0,User,0,User.length);		


		}

		if (value == 9)
		{
			Fight a9 = new Fight(9, 10, 3, 2,7,0,10,1, "일어나기 힘든 1교시 수업");
			System.arraycopy(a9.Battle(User),0,User,0,User.length);			

		}
		if (value == 10)
		{
			Fight a10 = new Fight(10, 11, 2, 2,8,0,12,1, "1교시 보다는 그나마 나은 2교시수업");
			System.arraycopy(a10.Battle(User),0,User,0,User.length);			

		}
		if (value == 11)
		{
			Fight a11 = new Fight(11, 12, 3, 2,9,0,13,1, "점심먹고 잠오는 3교시 수업");
			System.arraycopy(a11.Battle(User),0,User,0,User.length);			

		}
		if (value == 12)
		{
			Fight a12 = new Fight(11, 13, 2, 2,9,0,15,1, "슬슬 집 생각이 나는 4교시 수업");
			System.arraycopy(a12.Battle(User),0,User,0,User.length);			

		}
		if (value == 13)
		{
			Fight a13 = new Fight(11, 13, 3, 2,10,0,15,1, "어서 집에 가고싶은 5교시 수업");
			System.arraycopy(a13.Battle(User),0,User,0,User.length);			

		}
		if (value == 14)
		{
			Fight a14 = new Fight(12, 14, 2, 2,10,0,17,1, "중간에 텅 비어버린 공강시간");
			System.arraycopy(a14.Battle(User),0,User,0,User.length);			

		}
		if (value == 15)
		{
			Fight a15 = new Fight(12, 15, 2, 3,10,0,20,1, "내일까지 해야하는 과제");
			System.arraycopy(a15.Battle(User),0,User,0,User.length);			

		}

		if (value == 16)
		{
			Fight b1 = new Fight(13, 15, 4, 3,13,0,21,2, "한번씩 치는 퀴즈");
			System.arraycopy(b1.Battle(User),0,User,0,User.length);			

		}
		if (value == 17)
		{
			Fight b2 = new Fight(13, 15, 4, 3,13,0,22,2, "기말 전까지 내야하는 레포트");
			System.arraycopy(b2.Battle(User),0,User,0,User.length);			

		}
		if (value == 18)
		{
			Fight b3 = new Fight(14, 16, 4, 3,13,0,22,2, "1교시 출석체크");
			System.arraycopy(b3.Battle(User),0,User,0,User.length);			

		}
		if (value == 19)
		{
			Fight b4 = new Fight(14, 16, 4, 3,15,0,23,2, "주말에 하는 보강");
			System.arraycopy(b4.Battle(User),0,User,0,User.length);			

		}

		if (value == 20)
		{
			Fight b5 = new Fight(15, 16, 4, 3,15,0,23,2, "북문 맛집 사장님");
			System.arraycopy(b5.Battle(User),0,User,0,User.length);

		}
		if (value == 21)
		{
			Fight b6 = new Fight(17, 17, 4, 3,15,0,24,2, "정문 술집 사장님");
			System.arraycopy(b6.Battle(User),0,User,0,User.length);


		}
		if (value == 22)
		{
			Fight b7 = new Fight(18, 18, 4, 3,15,0,24,2, "학생식당 아주머니");
			System.arraycopy(b7.Battle(User),0,User,0,User.length);


		}
		if (value == 23)
		{

			Fight b8 = new Fight(18, 19, 4, 3,16,0,24,2, "매점 아주머니");
			System.arraycopy(b8.Battle(User),0,User,0,User.length);

		}
		if (value == 24)
		{
			Fight b9 = new Fight(19, 20, 4, 5,17,0,25,2, "수업 째자 꼬시는 학과 동기");
			System.arraycopy(b9.Battle(User),0,User,0,User.length);

		}
		if (value == 25)
		{
			Fight b10 = new Fight(19, 21, 4, 5,17,0,25,2, "술사주는 학과 선배");
			System.arraycopy(b10.Battle(User),0,User,0,User.length);

		}

		if (value == 26)
		{
			Fight c1 = new Fight(27, 22, 5, 2,17,0,30,3, "밥사주는 동아리 회장님");
			System.arraycopy(c1.Battle(User),0,User,0,User.length);


		}
		if (value == 27)
		{
			Fight c2 = new Fight(28, 23, 5, 2,17,0,30,3, "자기 주량도 모르고 맛이 간 신입생");
			System.arraycopy(c2.Battle(User),0,User,0,User.length);


		}
		if (value == 28)
		{
			Fight c3 = new Fight(29, 24, 6, 2,18,0,30,3, "족보 좀 달라는 학과 후배");
			System.arraycopy(c3.Battle(User),0,User,0,User.length);

		}
		if (value == 29)
		{
			Fight c4 = new Fight(31, 25, 6, 2,18,0,32,3, "조별과제 무임승차 조원");
			System.arraycopy(c4.Battle(User),0,User,0,User.length);

		}
		if (value == 30)
		{
			Fight c5 = new Fight(33, 26, 5, 2,19,0,32,3, "똥군기 잡는 극혐 선배");
			System.arraycopy(c5.Battle(User),0,User,0,User.length);
		}

		if (value == 31)
		{
			Fight c6 = new Fight(35, 27, 5, 3,19,0,32,3, "돈빌리고 안갚는 학교 친구");
			System.arraycopy(c6.Battle(User),0,User,0,User.length);

		}

		if (value == 32)
		{
			Fight c7 = new Fight(36, 28, 7, 3,20,0,34,3, "헤어진 전 여자친구");
			System.arraycopy(c7.Battle(User),0,User,0,User.length);

		}

		if (value == 33)
		{
			Fight c8 = new Fight(37, 29, 9, 3,20,0,34,3, "헤어진 전 남자친구");
			System.arraycopy(c8.Battle(User),0,User,0,User.length);

		}

		if (value == 34)
		{
			Fight c9 = new Fight(38, 30, 11, 4,20,0,34,3, "집중 안하면 바로 놓치는 외국인 교수님");
			System.arraycopy(c9.Battle(User),0,User,0,User.length);

		}

		if (value == 35)
		{
			Fight c10 = new Fight(39, 29, 13, 5,17,0,35,3, "자필로 보고서 써오라 하시는 실험 교수님");
			System.arraycopy(c10.Battle(User),0,User,0,User.length);

		}

		if (value == 36)
		{
			Fight c11 = new Fight(40, 28, 15, 5,21,0,35,3, "상담때만 한번씩 뵙는 지도교수님 ");
			System.arraycopy(c11.Battle(User),0,User,0,User.length);

		}

		if (value == 37)
		{
			Fight d1 = new Fight(46, 30, 16, 2,23,0,35,4, "매일 출석체크 하시는 교양 교수님");
			System.arraycopy(d1.Battle(User),0,User,0,User.length);

		}

		if (value == 38)
		{
			Fight d2 = new Fight(47, 30, 17, 2,24,0,38,4, "수면제 전공 교수님");
			System.arraycopy(d2.Battle(User),0,User,0,User.length);

		}

		if (value == 39)
		{
			Fight d3 = new Fight(48, 31, 16, 2,25,0,40,4, "자유의 상징 F학점");
			System.arraycopy(d3.Battle(User),0,User,0,User.length);
		}

		if (value == 40)
		{
			Fight d4 = new Fight(50, 32, 18, 2,27,0,45,4, "받아본 사람만 안다는 D학점");
			System.arraycopy(d4.Battle(User),0,User,0,User.length);

		}

		if (value == 41)
		{
			Fight d5 = new Fight(51, 32, 19, 2,28,0,47,4, "출석은 했지만 시험은 망쳤다 C학점");
			System.arraycopy(d5.Battle(User),0,User,0,User.length);
		}

		if (value == 42)
		{
			Fight d6 = new Fight(52, 33, 20, 2,29,0,48,4, "안심과 아쉬움의 공존 B학점");
			System.arraycopy(d6.Battle(User),0,User,0,User.length);
		}

		if (value == 43)
		{
			Fight e1 = new Fight(70, 40, 25, 2,30,0,50,5, "열심히한 노력의 대가  A학점");
			System.arraycopy(e1.Battle(User),0,User,0,User.length);

		}

		if (value == 44)
		{
			Fight e2 = new Fight(80, 40, 30, 15,35,0,55,5, "A+학점");
			System.arraycopy(e2.Battle(User),0,User,0,User.length);
		}

		return User;
	}
	
	public static int[][][] Battle(int [][][] User) throws InterruptedException, IOException
	{	
		Hunt hunt = new Hunt();
		Scanner input = new Scanner(System.in);


			System.out.printf("\n당신은 %s와(과) 마주했다!", MonsterName);
			while(true)
			{
				System.out.printf("\n(%s LV : %d, 체력 : %d, 공격력 %d)\n",MonsterName,Status[7],Status[0],Status[1]);
				System.out.println("\n무엇을 하시겠습니까?\n공격 : 1, 도망 : 2, 아이템 : 3");	
				int  i = input.nextInt();

				if (i == 1)
				{
					Status[0] -= DamageCalculation(User[0][6][1], Status[2]);

					System.out.printf("\n당신은 %s을(를) 공격합니다.\n",MonsterName);
					
					if (Status[0] > 0)
					{
						System.out.printf("(%s 체력 : %d)\n", MonsterName,Status[0]);
						Thread.sleep(1500);
					}
					else
					{
						System.out.printf("(%s 체력 : 0)\n", MonsterName);
						Thread.sleep(1500);
					}


					if (Status[0] <= 0)
					{
						System.out.printf("\n당신은 %s에게서 승리했다!\n", MonsterName);
						System.out.printf("(경험 +%d, 골드 +%d)\n\n", Status[4], Status[6]);
						User[0][0][4] += Status[4];
						User[0][0][6] += Status[6];
						break;
					}

					System.out.printf("\n%s이(가) 당신을 공격합니다.\n", MonsterName);
					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);

					if (User[0][6][0] > 0)
					{
						System.out.printf("(당신의 체력 : %d)\n", User[0][6][0]);
						Thread.sleep(1500);
					}
					else
					{
						System.out.printf("(당신의 체력 : 0)\n");
						Thread.sleep(1500);
					}

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s이(가) 당신을 처치했습니다.\n\n",MonsterName);
						break;
					}
				}

				if (i==2)
				{
					if ((int)(Math.random()*User[0][6][3]) > (int)(Math.random()*Status[3]))
					{	Thread.sleep(3000);
						System.out.println("\n도망 성공!.\n"); break;	
					}
					else
					{	Thread.sleep(1500);
						System.out.println("\n도망 실패!");
						System.out.printf("\n%s이(가) 당신을 공격합니다.\n", MonsterName);
						User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
						User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);

						if (User[0][6][0] > 0)
						{
							System.out.printf("(당신의 체력 : %d)\n", User[0][6][0]);
							Thread.sleep(1500);
						}
						else
						{
							System.out.printf("(당신의 체력 : 0)\n");
							Thread.sleep(1500);
						}

						if (User[0][6][0] <=0)
						{
							System.out.printf("\n%s이(가) 당신을 처치했습니다.\n\n",MonsterName);
							break;
						}	
					}
				}		
				
				if(i == 3)
				{
					
					System.arraycopy(hunt.UsingItem(User),0,User,0,User.length);	

					System.out.printf("\n%s이 당신을 공격합니다.\n", MonsterName);
					Thread.sleep(1500);

					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					

					if (User[0][6][0] > 0)
					{
						System.out.printf("(당신의 체력 : %d)\n", User[0][6][0]);
					}
					else
					{
						System.out.printf("(당신의 체력 : 0)\n");
					}

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s이(가) 당신을 처치했습니다.\n\n",MonsterName);
						break;
					}
				}


			}


		return User;
	}

	public static int DamageCalculation(int Atk, int Def)
	{
		double a = (double)(Atk);
		double d = (double)(Def);
		double RealDamage = 0;

		RealDamage = a*(1- (d/(d+100)));

		return (int)(RealDamage);
	}

	






















}